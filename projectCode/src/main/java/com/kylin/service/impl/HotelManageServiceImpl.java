package com.kylin.service.impl;

import com.kylin.model.*;
import com.kylin.repository.*;
import com.kylin.service.HotelManageService;
import com.kylin.tools.myexception.BadInputException;
import com.kylin.tools.myexception.DataIntegrityException;
import com.kylin.tools.DateHelper;
import com.kylin.vo.*;
import com.kylin.vo.common.MyMessage;
import com.kylin.tools.myenum.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
@Service
public class HotelManageServiceImpl implements HotelManageService {

    @Autowired
    private HotelRepository hotelRepository;
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
    private MemberRepository memberRepository;

    @Override
    public List<SearchHotelItemVO> search(String location, String fromDate, String endDate,
                                          int roomTypeInt, int roomNumber) {
        List<SearchHotelItemVO> result = new ArrayList<>();
        try {
            Date checkInDate = DateHelper.getDate(fromDate);
            Date checkOutDate = DateHelper.getDate(endDate);

            // find by location
            List<Hotel> hotelList = this.hotelRepository.findByLocation(location);
            RoomType roomType = RoomType.getEnum(roomTypeInt);

            // find by date and people
            for (Hotel hotel : hotelList) {
                // 酒店剩余房间信息
                List<HotelRemainRoom> remainRooms =
                        this.emptyRoomSearch(hotel.getId(), fromDate, endDate, roomType);
                // 还有足够的剩余房间
                if (remainRooms.size() >= roomNumber) {
                    // 一个酒店剩余房间的信息
                    SearchHotelItemVO vo = this.getRemainInfo(hotel, checkInDate, checkOutDate, remainRooms);
                    result.add(vo);
                }
                //否则这个酒店剩余的房间不够,继续检查下一个
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 一个酒店剩余房间的信息
     *
     * @param hotel        酒店
     * @param checkInDate  时间
     * @param checkOutDate 时间
     * @param remainRooms  剩余房间信息列表
     * @return
     */
    private SearchHotelItemVO getRemainInfo(Hotel hotel, Date checkInDate, Date checkOutDate,
                                            List<HotelRemainRoom> remainRooms) {
        int lowestPerNightPrice = Integer.MAX_VALUE;
        List<RemainRoomInfo> roomResult = new ArrayList<>();

        // 初始化每一个类型
        Map<RoomType, RemainRoomInfo> typeAndNumber = new HashMap<>();
        for (RoomType oneType : RoomType.values()) {
            RemainRoomInfo remainRoomInfo = new RemainRoomInfo(oneType, 0, Integer.MAX_VALUE);
            typeAndNumber.put(oneType, remainRoomInfo);
        }

        // 对每一个空余的房间信息
        for (HotelRemainRoom room : remainRooms) {
            int roomId = room.getRoomId();
            RoomType roomType = room.getType();
            // 一个区域的房价以checkIn当天价格为准
            int price = this.roomStatusRepository.getPriceByRoomIdAndDate(roomId, checkInDate);

            //修改返回的搜索结果
            RemainRoomInfo oldInfo = typeAndNumber.get(roomType);
            oldInfo.increaseNumber();
            oldInfo.calculatePrice(price);
        }

        //将每种房间的信息返回
        roomResult.addAll(typeAndNumber.values());

        return new SearchHotelItemVO(checkInDate, checkOutDate, hotel.getId(),
                hotel.getName(), HotelType.getEnum(hotel.getType()), hotel.getLocation(),
                lowestPerNightPrice, roomResult);
    }

    @Override
    public boolean makeReservation(ReserveInputTableVO inputVO) {
        // 保存用户订单信息
        Hotel hotel = this.hotelRepository.findOne(inputVO.getHotelId());
        this.saveOrder(inputVO, hotel);

        // get input info
        Date checkIn = inputVO.getCheckInDate();
        Date checkOut = inputVO.getCheckOutDate();
        RoomType roomType = inputVO.getRoomType();
        int roomNumber = inputVO.getRoomNumber();

        // TODO 缓存技术
        // 找到当前酒店所有在指定日期/指定类型的,空闲的房间,例如有10个
        List<HotelRemainRoom> remainRooms = this.emptyRoomSearch(hotel.getId(),
                DateHelper.getDateString(checkIn), DateHelper.getDateString(checkOut), roomType);

        // 取出用户要求数量的房间数目,例如用户只要两个
        for (int i = 0; i < roomNumber; i++) {
            HotelRemainRoom remainRoom = remainRooms.get(i);
            int roomId = remainRoom.getRoomId();
            int roomState = RoomStatus.Empty.ordinal();

            // 得到这个房间的信息
            List<HotelRoomStatus> roomStatusList = this.roomStatusRepository.findByRoomAndDateAndStatus
                    (roomId, checkIn, checkOut, roomState);

            // 更新每一天房间的状态为被预定,防止被别人重复预定
            int targetState = RoomStatus.Reserved.ordinal();
            for (HotelRoomStatus roomStatus : roomStatusList) {
                roomStatus.setStatus(targetState);
                this.roomStatusRepository.save(roomStatus);
            }
        }

        return true;
    }

    /**
     * 保存用户的输入订单信息
     *
     * @param inputVO
     * @param hotel
     */
    private void saveOrder(ReserveInputTableVO inputVO, Hotel hotel) {
        UserOrder userOrder = new UserOrder();
        Member member = this.memberRepository.findOne(inputVO.getUserId());
        userOrder.setUserByUserId(member);

        userOrder.setHotelByHotelId(hotel);

        //时间信息
        Date checkIn = inputVO.getCheckInDate();
        Date checkOut = inputVO.getCheckOutDate();
        userOrder.setCheckIn(checkIn);
        userOrder.setCheckOut(checkOut);
        userOrder.setOrderTime(new Date());

        //房间信息
        RoomType roomType = inputVO.getRoomType();
        userOrder.setRoomType(roomType.ordinal());
        int roomNumber = inputVO.getRoomNumber();
        userOrder.setRoomNumber(roomNumber);
        userOrder.setPrice(inputVO.getTotalPrice());

        //联系人信息
        userOrder.setContactName(inputVO.getContactPersonName());
        userOrder.setContactPhone(inputVO.getContactPhone());
        userOrder.setContactEmail(inputVO.getContactEmail());

        userOrder.setStatus(MemberOrderStatus.Reserved.ordinal());
        //保存
        this.orderRepository.save(userOrder);
    }

    @Override
    // 此方法找到,一个酒店的,指定房间类型,在起点-终点日期内为空闲的所有空余信息
    public List<HotelRemainRoom> emptyRoomSearch(int hotelId, String fromDate, String endDate, RoomType roomType) {
        // get all room of this hotel
        List<HotelRoom> hotelRoomIdList = this.hotelRoomRepository.findByHotelId(hotelId);
        List<HotelRemainRoom> result = new ArrayList<>();

        try {
            // date info
            Date from = DateHelper.getDate(fromDate);
            Date end = DateHelper.getDate(endDate);
            int dayNumber = DateHelper.getDaysNumber(from, end);
            // every room of this hotel
            for (HotelRoom room : hotelRoomIdList) {
                // every target type room between these dates
                if (room.getType() == roomType.ordinal()) {
                    // 找的是空闲的房间
                    int roomState = RoomStatus.Empty.ordinal();
                    List<HotelRoomStatus> roomStatusList = this.roomStatusRepository.findByRoomAndDateAndStatus
                            (room.getId(), from, end, roomState);

                    // 房间必须在所有这些天数里面,包含起点终点,都是空闲的
                    if (roomStatusList.size() == dayNumber) {
                        //发现一个符合要求的房间
                        HotelRemainRoom remainRoom = new HotelRemainRoom(room.getId(),
                                room.getRoomNumber(), RoomType.getEnum(room.getType()),
                                RoomStatus.Empty, room.getInformation());
                        result.add(remainRoom);
                    }
                }
                // type is wrong, check next room
            }
            return result;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public MyMessage customCheckIn(HotelCheckInTableVO hotelCheckInTableVO) throws BadInputException {
        // get input info
        int hotelId = hotelCheckInTableVO.getHotelId();
        int orderId = hotelCheckInTableVO.getOrderId();
        List<HotelRoomCheckIn> hotelRoomCheckInList = hotelCheckInTableVO.getHotelRoomCheckInList();
        boolean isMember = hotelCheckInTableVO.isMember();
        PaymentType paymentType = hotelCheckInTableVO.getPaymentType();

        // 检查输入的房间信息是否和订单信息匹配
        UserOrder order = orderRepository.findOne(orderId);
        int orderedRoomNum = order.getRoomNumber();
        int inputRoomNum = hotelRoomCheckInList.size();
        if (orderedRoomNum != inputRoomNum)
            throw new BadInputException("订单预定了 " + orderedRoomNum + " 个房间, 但是输入了" + inputRoomNum + " 个房间,不匹配.");

        // 检查订单状态
        if (order.getStatus() != MemberOrderStatus.Reserved.ordinal())
            throw new BadInputException("订单id=" + order.getStatus()+"状态不正确:");

        // 检查输入的房间-客户信息是否与酒店的房间符合
        this.hotelRoomCheck(hotelId, hotelRoomCheckInList);

        // update the order
        this.updateOrder(order, isMember, paymentType);

        // TODO bug 预定两个房间,先修改了第一个,第二个不符合条件则产生异常,但是第一个已经修改了
        for (HotelRoomCheckIn roomCheckIn : hotelRoomCheckInList) {
            // update remain room status
            this.updateRoomStatus(order, roomCheckIn);

            // register every guest
            for (HotelGuestCheckIn guestCheckIn : roomCheckIn.getGuestList()) {
                this.registerGuest(guestCheckIn, order, roomCheckIn);
            }
        }
        return new MyMessage(true);
    }

    /**
     * 更新房间的剩余信息
     *
     * @param order       订单
     * @param roomCheckIn 房间入住信息
     * @throws BadInputException 如果入住的目标房间不是空闲的则报错误
     */
    private void updateRoomStatus(UserOrder order, HotelRoomCheckIn roomCheckIn) throws BadInputException {
        // order date
        Date checkIn = order.getCheckIn();
        Date checkOut = order.getCheckOut();
        int orderDayNumber = DateHelper.getDaysNumber(checkIn, checkOut);
        // target room
        int roomId = roomCheckIn.getRoomId();

        // 得到这个目标房间在输入的日期,且状态是已预定但未入住的列表
        int reservedState = RoomStatus.Reserved.ordinal();
        List<HotelRoomStatus> statusList = this.roomStatusRepository.findByRoomAndDateAndStatus(
                roomId, checkIn, checkOut, reservedState);

        // 如果日期数目不匹配,则报错
        if (statusList.size() != orderDayNumber)
            throw new BadInputException("房间 roomId=" + roomId +
                    " 在日期 " + DateHelper.getDateString(checkIn) +
                    " 到日期 " + DateHelper.getDateString(checkOut) + " 没有已预定但未入住的");

        for (HotelRoomStatus roomStatus : statusList) {
            roomStatus.setStatus(RoomStatus.CheckedIn.ordinal());
            // 更新数据
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
    private void registerGuest(HotelGuestCheckIn guestCheckIn, UserOrder order, HotelRoomCheckIn roomCheckIn) {
        RoomGuest roomGuest = new RoomGuest();
        // set guest info
        roomGuest.setDate(new Date());
        roomGuest.setName(guestCheckIn.getName());
        roomGuest.setIdNum(guestCheckIn.getIDNum());
        // order foreign key
        roomGuest.setOrderByOrderId(order);
        // room foreign key
        HotelRoom room = roomRepository.findOne(roomCheckIn.getRoomId());
        roomGuest.setRoomByRoomId(room);

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
    private void updateOrder(UserOrder order, boolean isMember, PaymentType paymentType) {

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

    /**
     * 检查输入的房间-客户信息是否与酒店的房间符合
     * 例如一个标准间只能入住2人,不可以是三个人
     *
     * @param hotelId              酒店
     * @param hotelRoomCheckInList 入住信息列表
     */
    private void hotelRoomCheck(int hotelId, List<HotelRoomCheckIn> hotelRoomCheckInList) throws BadInputException {
        for (HotelRoomCheckIn roomCheckIn : hotelRoomCheckInList) {
            // every room info
            HotelRoom room = this.roomRepository.findOne(roomCheckIn.getRoomId());

            // hotel id info
            if (room.getHotelId() != hotelId)
                throw new BadInputException("房间:" + room.getRoomNumber() + "不属于酒店!" + "room id=" + room.getId() +
                        "本酒店id=" + hotelId + "房间属于的酒店id=" + room.getHotelId());

            int roomTypeInt = room.getType();
            RoomType roomType = RoomType.getEnum(roomTypeInt);

            int maxPeople = roomType.getPeople();
            // check in people
            int checkInPeople = roomCheckIn.getGuestList().size();
            // too many people
            if (checkInPeople > maxPeople)
                throw new BadInputException("房间" + room.getRoomNumber() + "入住人数:"
                        + checkInPeople + "超过最大人数:" + maxPeople + "!");
        }
    }

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

            // if this room has plan
            int listSize = list.size();
            if (listSize > 0) {
                Date end = list.get(0).getDate();
                Date start = list.get(listSize - 1).getDate();

                HotelPlanVO hotelPlanVO = new HotelPlanVO(hotelRoomId, hotelRoom.getRoomNumber(),
                        RoomType.getEnum(hotelRoom.getType()), start, end);
                // add this room to planned list
                result.add(hotelPlanVO);
            }
        }

        return result;
    }

    @Override
    public MyMessage makePlan(HotelPlanInputVO hotelPlanInputVO) throws DataIntegrityException {
        // get the room of the hotel
        int hotelRoomId = hotelPlanInputVO.getHotelRoomId();
        HotelRoom hotelRoom = this.hotelRoomRepository.getOne(hotelRoomId);
        if (hotelRoom == null)
            throw new DataIntegrityException("酒店房间不存在, hotelRoomId = " + hotelRoomId);

        // get room plan info
        Date checkInDate = hotelPlanInputVO.getCheckInDate();
        Date checkOutDate = hotelPlanInputVO.getCheckOutDate();
        int price = hotelPlanInputVO.getPrice();

        // current plan
        List<HotelRoomStatus> list = roomStatusRepository.
                findByHotelRoomIdOrderByDateDesc(hotelRoomId);
        if (list.size() > 0) {
            HotelRoomStatus latestPlan = list.get(0);
            Date latestDate = latestPlan.getDate();
            if (checkInDate.before(latestDate)) {
                throw new DataIntegrityException("计划冲突！已有的计划结束日期:" + DateHelper.getDateString(latestDate) + "" +
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
}
