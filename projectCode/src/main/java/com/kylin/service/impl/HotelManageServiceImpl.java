package com.kylin.service.impl;

import com.kylin.model.*;
import com.kylin.repository.*;
import com.kylin.service.HotelManageService;
import com.kylin.tools.DateHelper;
import com.kylin.tools.myenum.MemberOrderStatus;
import com.kylin.tools.myenum.PaymentType;
import com.kylin.tools.myenum.RoomStatus;
import com.kylin.tools.myenum.RoomType;
import com.kylin.tools.myexception.BadInputException;
import com.kylin.vo.*;
import com.kylin.vo.common.MyMessage;
import com.kylin.tools.myenum.PaymentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
@Service
public class HotelManageServiceImpl implements HotelManageService {

    @Autowired
    private HotelRoomRepository hotelRoomRepository;
    @Autowired
    private HotelRoomStatusRepository roomStatusRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private HotelRoomRepository roomRepository;
    @Autowired
    private RoomGuestRepository guestRepository;
    @Autowired
    private PaymentRepository paymentRepository;


    @Override
    public List<HotelPlanVO> getHotelPlan(int hotelId) {
        // get all room of this hotel
        List<HotelRoom> hotelRoomIdList = this.hotelRoomRepository.findByHotelId(hotelId);

        // current plan of every room
        List<HotelPlanVO> result = new ArrayList<>();
        for (HotelRoom hotelRoom : hotelRoomIdList) {
            int hotelRoomId = hotelRoom.getId();
            // the current plan of thi room
            List<HotelRoomStatus> list = roomStatusRepository.
                    findByHotelRoomIdOrderByDateDesc(hotelRoomId);

            int type = hotelRoom.getType();
            RoomType roomType = RoomType.getEnum(type);

            HotelPlanVO hotelPlanVO;
            int listSize = list.size();
            // if this room has plan
            if (listSize > 0) {
                Date end = list.get(0).getDate();
                Date start = list.get(listSize - 1).getDate();

                hotelPlanVO = new HotelPlanVO(hotelRoomId, hotelRoom.getRoomNumber(),
                        roomType, start, end);
                // this room has no plan yet
            } else {
                hotelPlanVO = new HotelPlanVO(hotelRoomId, hotelRoom.getRoomNumber(),
                        roomType, "暂无计划", "暂无计划");
            }
            // add this room to planned list
            result.add(hotelPlanVO);

        }

        return result;
    }

    @Override
    public MyMessage makePlan(HotelPlanInputVO hotelPlanInputVO) {
        // get the room of the hotel
        int hotelRoomId = hotelPlanInputVO.getHotelRoomId();
        HotelRoom hotelRoom = this.hotelRoomRepository.findOne(hotelRoomId);
        if (hotelRoom == null)
            return new MyMessage(false,"酒店房间不存在, hotelRoomId = " + hotelRoomId);

        // get room plan info
        Date checkInDate = hotelPlanInputVO.getCheckInDate();
        Date checkOutDate = hotelPlanInputVO.getCheckOutDate();
        int price = hotelPlanInputVO.getPrice();

        // current plan
        List<HotelRoomStatus> list = roomStatusRepository.
                findByHotelRoomIdOrderByDateDesc(hotelRoomId);
        if (list.size() > 0) {
            // 日期最大的一个计划
            HotelRoomStatus latestPlan = list.get(0);
            Date latestDate = latestPlan.getDate();
            if (!checkInDate.after(latestDate)) {
                return new MyMessage(false,"计划冲突！已有的计划结束日期:" + DateHelper.getDateString(latestDate) + "" +
                        "输入的计划开始日期:" + DateHelper.getDateString(checkInDate));
            }
        } // 当前没有计划

        // set room is available between these days
        List<Date> dates = DateHelper.getBetweenDates(checkInDate, checkOutDate);
        for (Date date : dates) {
            // 新增房间状态计划
            HotelRoomStatus roomStatus = new HotelRoomStatus(hotelRoomId, date,
                    RoomStatus.Empty.ordinal(), price);
            roomStatusRepository.save(roomStatus);
        }
        return new MyMessage(true);
    }

    // 入住登记开始
    @Override
    public MyMessage customCheckIn(final HotelCheckInTableVO input) {
        // 获取等级表格信息
        int hotelId = input.getHotelId();
        int orderId = input.getOrderId();
        List<HotelRoomCheckIn> hotelRoomCheckInList = input.getHotelRoomCheckInList();
        boolean isMember = input.isMember();
        PaymentType paymentType = input.getPaymentType();

        // 查找对应的用户订单
        MemberOrder order = orderRepository.findOne(orderId);

        // 如果没有通过检查,则返回错误信息
        MyMessage check = this.checkInCheck(hotelId, order, hotelRoomCheckInList);
        if (!check.isSuccess())
            return check;

        // 检查通过,更新各项数据 每个房间信息
        for (HotelRoomCheckIn roomCheckIn : hotelRoomCheckInList) {
            // 1.更新每个房间状态为入住
            this.updateRoomStatus(order, roomCheckIn);

            // 2.新增每个房间里面的 每个房客信息列表
            for (HotelGuestCheckIn guestCheckIn : roomCheckIn.getGuestList()) {
                this.registerGuest(guestCheckIn, order, roomCheckIn);
            }
        }

        // 3.更新订单信息为已经入住
        this.updateOrder(order, isMember, paymentType);

        // 4.记录付款信息
        this.makePayment(hotelId, order.getMemberId(), order.getPrice());

        return new MyMessage(true);
    }

    // 入住登记: 登记信息检查 3 个方法
    private MyMessage checkInCheck(int hotelId, MemberOrder order, List<HotelRoomCheckIn> hotelRoomCheckInList) {

        // 1.检查输入的房间信息 是否和订单里面的房间数目 匹配
        MyMessage orderCheck = this.orderCheck(order, hotelRoomCheckInList);
        // 如果没有通过检查,则返回错误信息
        if (!orderCheck.isSuccess())
            return orderCheck;

        // 2.检查输入的房间-客户信息是否与酒店的房间符合
        MyMessage roomCheck = this.hotelRoomCheck(hotelId, hotelRoomCheckInList);
        // 如果没有通过检查,则返回错误信息
        if (!roomCheck.isSuccess())
            return roomCheck;

        // 3.检查每一个房间是否 状态为 已预定但未入住
        MyMessage roomStatusCheck = this.roomStatusCheck(order, hotelRoomCheckInList);
        // 如果没有通过检查,则返回错误信息
        if (!roomStatusCheck.isSuccess())
            return roomStatusCheck;

        return new MyMessage(true);
    }

    /**
     * 检查输入的房间-客户信息是否与酒店的房间符合
     * 例如一个标准间只能入住2人,不可以是三个人
     *
     * @param hotelId              酒店
     * @param hotelRoomCheckInList 入住信息列表
     */
    private MyMessage hotelRoomCheck(int hotelId, List<HotelRoomCheckIn> hotelRoomCheckInList) {
        for (HotelRoomCheckIn roomCheckIn : hotelRoomCheckInList) {
            // every room info
            final HotelRoom room = this.roomRepository.findOne(roomCheckIn.getRoomId());

            // hotel id info
            if (room.getHotelId() != hotelId)
                return new MyMessage(false, "房间:" + room.getRoomNumber() + "不属于酒店!" + "room id=" + room.getId() +
                        "本酒店id=" + hotelId + "房间属于的酒店id=" + room.getHotelId());

            int roomTypeInt = room.getType();
            RoomType roomType = RoomType.getEnum(roomTypeInt);

            int maxPeople = roomType.getPeople();
            // check in people
            int checkInPeople = roomCheckIn.getGuestList().size();
            // too many people
            if (checkInPeople > maxPeople)
                return new MyMessage(false, "房间" + room.getRoomNumber() + "入住人数:"
                        + checkInPeople + "超过最大人数:" + maxPeople + "!");
        }
        return new MyMessage(true);
    }

    private MyMessage roomStatusCheck(MemberOrder order, List<HotelRoomCheckIn> roomCheckInList) {
        // order date
        Date checkIn = order.getCheckIn();
        Date checkOut = order.getCheckOut();
        int orderDayNumber = DateHelper.getDaysNumber(checkIn, checkOut);

        // 检查每一个房间
        for (HotelRoomCheckIn roomCheckIn : roomCheckInList) {
            // target room
            int roomId = roomCheckIn.getRoomId();

            // 得到这个目标房间在输入的日期,且状态是已预定但未入住的列表
            int reservedState = RoomStatus.Reserved.ordinal();
            List<HotelRoomStatus> statusList = this.roomStatusRepository.findByRoomAndDateAndStatus(
                    roomId, checkIn, checkOut, reservedState);

            // 如果日期数目不匹配,则报错
            if (statusList.size() != orderDayNumber)
                return new MyMessage(false, "房间 roomId=" + roomId +
                        " 在日期 " + DateHelper.getDateString(checkIn) +
                        " 到日期 " + DateHelper.getDateString(checkOut) + " 没有已预定但未入住的");
        }

        return new MyMessage(true);
    }

    private MyMessage orderCheck(MemberOrder order, List<HotelRoomCheckIn> hotelRoomCheckInList) {

        // 订单里面的数目
        int orderedRoomNum = order.getRoomNumber();
        // 酒店输入的数目
        int inputRoomNum = hotelRoomCheckInList.size();
        if (orderedRoomNum != inputRoomNum)
            return new MyMessage(false, "订单预定了 " + orderedRoomNum + " 个房间, 但是输入了" + inputRoomNum + " 个房间,不匹配.");

        // 检查订单状态是否是预定但未入住
        if (order.getStatus() != MemberOrderStatus.Reserved.ordinal())
            return new MyMessage(false, "订单id=" + order.getStatus() + "状态不正确");

        return new MyMessage(true);
    }

    // 入住登记: 修改登记信息 4个方法
    private void makePayment(int hotelId, int memberId, int price) {
        Payment payment = new Payment();
        payment.setMemberId(memberId);
        payment.setHotelId(hotelId);
        payment.setPrice(price);

        payment.setStatus(PaymentStatus.PayedToHotel.ordinal());
        payment.setTime(new Date());

        this.paymentRepository.save(payment);
    }

    /**
     * 更新房间的剩余信息
     *
     * @param order       订单
     * @param roomCheckIn 房间入住信息
     * @throws BadInputException 如果入住的目标房间不是空闲的则报错误
     */
    private void updateRoomStatus(MemberOrder order, HotelRoomCheckIn roomCheckIn) {
        // order date
        Date checkIn = order.getCheckIn();
        Date checkOut = order.getCheckOut();
        // target room
        int roomId = roomCheckIn.getRoomId();

        // 得到这个目标房间在输入的日期,且状态是已预定但未入住的列表
        int reservedState = RoomStatus.Reserved.ordinal();
        List<HotelRoomStatus> statusList = this.roomStatusRepository.findByRoomAndDateAndStatus(
                roomId, checkIn, checkOut, reservedState);

        // 更新每一个房间的状态为已经入住
        for (HotelRoomStatus roomStatus : statusList) {
            roomStatus.setStatus(RoomStatus.CheckedIn.ordinal());
            this.roomStatusRepository.save(roomStatus);
        }
    }

    /**
     * 注册每一个房客信息
     *
     * @param guestCheckIn 一个房客
     * @param order        房客属于的订单信息
     * @param roomCheckIn  一个房间
     */
    private void registerGuest(HotelGuestCheckIn guestCheckIn, MemberOrder order, HotelRoomCheckIn roomCheckIn) {
        RoomGuest roomGuest = new RoomGuest();
        // set guest info
        roomGuest.setDate(new Date());
        roomGuest.setName(guestCheckIn.getName());
        roomGuest.setIdNum(guestCheckIn.getIDNum());
        // order foreign key
        roomGuest.setOrderId(order.getId());
        // room foreign key
        roomGuest.setRoomId(roomCheckIn.getRoomId());

        // save room guest
        this.guestRepository.save(roomGuest);
    }

    /**
     * 改变订单的状态
     *
     * @param order       订单
     * @param isMember    是否会员
     * @param paymentType 付款方式
     */
    private void updateOrder(MemberOrder order, boolean isMember, PaymentType paymentType) {

        // set order is from member
        if (isMember)
            order.setIsMember(1);
        else
            order.setIsMember(0);
        // set order payment type
        if (paymentType == PaymentType.Cash)
            order.setIsCash(1);
        else
            order.setIsCash(0);
        // 设置状态为已经入住
        order.setStatus(MemberOrderStatus.CheckedIn.ordinal());

        this.orderRepository.save(order);
    }
}
