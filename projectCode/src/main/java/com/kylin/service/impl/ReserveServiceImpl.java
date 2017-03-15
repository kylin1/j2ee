package com.kylin.service.impl;

import com.kylin.model.*;
import com.kylin.repository.*;
import com.kylin.service.ReserveService;
import com.kylin.tools.DateHelper;
import com.kylin.tools.myenum.*;
import com.kylin.vo.*;
import com.kylin.vo.common.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

/**
 * Created by kylin on 28/02/2017.
 * All rights reserved.
 */
@Service
public class ReserveServiceImpl implements ReserveService {

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private HotelRoomRepository hotelRoomRepository;
    @Autowired
    private HotelRoomStatusRepository roomStatusRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private MemberRepository memberRepository;


    @Autowired
    private HotelManageServiceImpl manageService;

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
                        //价格以第一天的价格为准
                        int price = roomStatusList.get(0).getPrice();
                        //发现一个符合要求的房间
                        HotelRemainRoom remainRoom = new HotelRemainRoom(room.getId(),
                                room.getRoomNumber(), RoomType.getEnum(room.getType()),
                                RoomStatus.Empty, room.getInformation(), price);
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
    public int getDiscount(int price, MemberLevel level) {
        // 折扣掉的数目
        double discountPercent[] = {0, 0.05, 0.2, 0.4};
        int levelInt = level.ordinal();
        int discount = (int) (price * discountPercent[levelInt]);
        return discount;
    }

    @Override
    public MyMessage reserveNonMember(NonMemberCheckInVO nonMemberCheckInVO) {
        System.out.println("before init : nonMemberCheckInVO = " + nonMemberCheckInVO);
        this.manageService.initCheckInTableVO(nonMemberCheckInVO);
        System.out.println("after init : nonMemberCheckInVO = " + nonMemberCheckInVO);

        // 新增订单
        MemberOrder newOrder = new MemberOrder();
        this.saveOrder(nonMemberCheckInVO, newOrder);

        return new MyMessage(true);
    }

    private void saveOrder(NonMemberCheckInVO nonMemberCheckInVO, MemberOrder newOrder) {
        newOrder.setStatus(MemberOrderStatus.CheckedIn.ordinal());
        newOrder.setHotelId(nonMemberCheckInVO.getHotelId());
        newOrder.setReservedRoomString(nonMemberCheckInVO.getRoomNumber());
        try {
            newOrder.setCheckIn(DateHelper.getDate(nonMemberCheckInVO.getStartDate()));
            newOrder.setCheckOut(DateHelper.getDate(nonMemberCheckInVO.getEndDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        newOrder.setContactName("");
        newOrder.setContactPhone("");
        newOrder.setContactEmail("");

        newOrder.setRoomNumber(1);
        newOrder.setIsCash(0);
        newOrder.setIsMember(0);
        newOrder.setOrderTime(new Date());
        newOrder.setRoomType(nonMemberCheckInVO.getIntPaymentType());
        this.orderRepository.save(newOrder);
    }


    @Override
    public List<SearchHotelItemVO> search(String location, String fromDate, String endDate,
                                          int roomTypeInt, int roomNumber) {
        List<SearchHotelItemVO> result = new ArrayList<>();
        try {
            Date checkInDate = DateHelper.getDate(fromDate);
            Date checkOutDate = DateHelper.getDate(endDate);

            // find by location
            List<Hotel> hotelList = this.hotelRepository.findByLocationIgnoreCaseContaining(location);
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


    @Override
    public MyMessage makeReservation(ReserveInputTableVO inputVO) {
        // 检查会员卡的余额是否足够,如果够则减去,并且增加消费总额,用户等级
        MyMessage myMessage = this.processBalanceAndLevel(inputVO);
        if (!myMessage.isSuccess()) {
            return myMessage;
        }

        Hotel hotel = this.hotelRepository.findOne(inputVO.getHotelId());

        // get input info
        Date checkIn = inputVO.getCheckInDate();
        Date checkOut = inputVO.getCheckOutDate();
        RoomType roomType = inputVO.getRoomType();
        int roomNumber = inputVO.getRoomNumber();

        // 找到当前酒店所有在指定日期/指定类型的,空闲的房间,例如有10个
        List<HotelRemainRoom> remainRooms = this.emptyRoomSearch(hotel.getId(),
                DateHelper.getDateString(checkIn), DateHelper.getDateString(checkOut), roomType);
        int remainRoomNum = remainRooms.size();
        if (remainRoomNum < roomNumber)
            return new MyMessage(false, hotel + "在" + checkIn + " 到 " + checkOut + "之间没有足够的空闲房间," +
                    "酒店只有" + remainRoomNum + "间空房");

        StringBuilder stringBuilder = new StringBuilder();
        // 取出用户要求数量的房间数目,例如用户只要两个
        for (int i = 0; i < roomNumber; i++) {
            HotelRemainRoom remainRoom = remainRooms.get(i);
            int roomId = remainRoom.getRoomId();
            int roomState = RoomStatus.Empty.ordinal();
            String roomNo = remainRoom.getRoom();
            stringBuilder.append(roomNo);
            if (i != roomNumber - 1) {
                stringBuilder.append(",");
            }

            // 得到这个房间的信息
            List<HotelRoomStatus> roomStatusList = this.roomStatusRepository.
                    findByRoomAndDateAndStatus(roomId, checkIn, checkOut, roomState);

            // 更新每一天房间的状态为被预定,防止被别人重复预定
            int targetState = RoomStatus.Reserved.ordinal();
            for (HotelRoomStatus roomStatus : roomStatusList) {
                roomStatus.setStatus(targetState);
                this.roomStatusRepository.save(roomStatus);
            }
        }

        // 获取为这个订单分配的房间列表
        String strRoomList = stringBuilder.toString();

        // 保存用户订单信息
        this.saveOrder(inputVO, hotel, strRoomList);

        return new MyMessage(true);
    }

    @Override
    public MyMessage cancelReservation(int orderId) {
        MemberOrder order = this.orderRepository.findOne(orderId);
        MemberOrderStatus orderStatus = MemberOrderStatus.getEnum(order.getStatus());
        if (orderStatus != MemberOrderStatus.Reserved) {
            return new MyMessage(false, "只有预定但没有入住的订单才能取消, 当前订单状态为 " + orderStatus.getStringStatus());
        }

        // 取回余额
        this.unProcessBalanceAndLevel(order);
        // 重新设置房间为空闲
        this.returnReservedRoom(order);
        // 设置订单状态为取消
        order.setStatus(MemberOrderStatus.Canceled.ordinal());
        this.orderRepository.save(order);

        return new MyMessage(true);
    }

    private void returnReservedRoom(MemberOrder order) {
        String reservedRoomString = order.getReservedRoomString();
        String[] roomNumbers = reservedRoomString.split(",");
        // 订单的基本信息
        int hotelId = order.getHotelId();
        Date checkIn = order.getCheckIn();
        Date checkOut = order.getCheckOut();

        for (String roomNumber : roomNumbers) {
            // 找到预定的一个房间
            HotelRoom hotelRoom = this.hotelRoomRepository.
                    findByHotelIdAndRoomNumber(hotelId, roomNumber);
            int hotelRoomId = hotelRoom.getId();

            // 被预定的房间,在两个日期之间的信息
            List<HotelRoomStatus> roomStatusList = this.roomStatusRepository.
                    findByRoomAndDate(hotelRoomId, checkIn, checkOut);

            // 将它们重新设置为可以预定
            int targetState = RoomStatus.Empty.ordinal();
            for (HotelRoomStatus roomStatus : roomStatusList) {
                roomStatus.setStatus(targetState);
                this.roomStatusRepository.save(roomStatus);
            }
        }
    }

    private void unProcessBalanceAndLevel(MemberOrder order) {
        // 订单信息
        int memberId = order.getMemberId();
        int price = order.getPrice();

        // 会员数据
        Member member = memberRepository.findOne(memberId);

        // 增加会员卡余额
        int oldBalance = member.getBalance();
        int newBalance = oldBalance + price;
        member.setBalance(newBalance);

        // 减去消费额
        int oldConsume = member.getConsume();
        int newConsume = oldConsume - price;
        member.setConsume(newConsume);

        // 减去积分
        int oldScore = member.getScore();
        int newScore = oldScore - price;
        member.setScore(newScore);

        // 修改用户等级
        MemberLevel level = this.getLevelByConsume(newConsume);
        member.setLevel(level.ordinal());

        // 回滚用户数据
        memberRepository.save(member);
    }

    private MyMessage processBalanceAndLevel(ReserveInputTableVO inputVO) {
        int memberId = inputVO.getMemberId();
        Member member = memberRepository.findOne(memberId);

        int currentBalance = member.getBalance();
        int price = inputVO.getTotalPrice();

        if (currentBalance < price) {
            return new MyMessage(false, "会员卡余额不足, 当前余额:" + currentBalance + ", 需支付金额:" + price);
        } else {
            // 新的会员卡余额 = 旧的 - 支付金额
            int newBalance = currentBalance - price;
            member.setBalance(newBalance);

            // 增加总消费额
            int oldConsume = member.getConsume();
            int newConsume = oldConsume + price;
            member.setConsume(newConsume);

            // 增加积分
            int oldScore = member.getScore();
            int newScore = oldScore + price;
            member.setScore(newScore);

            // 修改用户等级
            MemberLevel level = this.getLevelByConsume(newConsume);
            member.setLevel(level.ordinal());
        }
        memberRepository.save(member);
        return new MyMessage(true);
    }

    private MemberLevel getLevelByConsume(int newConsume) {
        if (newConsume > 1000) {
            return MemberLevel.High;
        } else if (newConsume > 500) {
            return MemberLevel.Middle;
        } else
            return MemberLevel.Low;
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
            // 每一个类型的房间,初始化为没有剩余的数量,价格为最大
            RemainRoomInfo remainRoomInfo = new RemainRoomInfo(oneType, 0, Integer.MAX_VALUE);
            typeAndNumber.put(oneType, remainRoomInfo);
        }

        // 对搜索到的本酒店每一个空余的房间信息
        for (HotelRemainRoom room : remainRooms) {
            int roomId = room.getRoomId();
            RoomType roomType = room.getType();
            // 一个区域的房价以checkIn当天价格为准
            int price = this.roomStatusRepository.getPriceByRoomIdAndDate(roomId, checkInDate);

            //修改返回的搜索结果
            RemainRoomInfo oldInfo = typeAndNumber.get(roomType);
            oldInfo.increaseNumber();
            oldInfo.calculatePrice(price);

            //修改房间最低单价
            if (price < lowestPerNightPrice) {
                lowestPerNightPrice = price;
            }
        }

        //将每种房间的信息返回
        roomResult.addAll(typeAndNumber.values());

        return new SearchHotelItemVO(checkInDate, checkOutDate, hotel.getId(),
                hotel.getName(), HotelLevel.getEnum(hotel.getLevel()), hotel.getLocation(),
                lowestPerNightPrice, roomResult);
    }

    /**
     * 保存用户的输入订单信息
     *
     * @param inputVO
     * @param hotel
     * @param strRoomList
     */
    private void saveOrder(ReserveInputTableVO inputVO, Hotel hotel, String strRoomList) {
        MemberOrder memberOrder = new MemberOrder();

        int memberId = inputVO.getMemberId();
        Member member = this.memberRepository.findOne(memberId);

        memberOrder.setMemberId(member.getId());
        memberOrder.setHotelId(hotel.getId());

        //时间信息
        Date checkIn = inputVO.getCheckInDate();
        Date checkOut = inputVO.getCheckOutDate();
        memberOrder.setCheckIn(checkIn);
        memberOrder.setCheckOut(checkOut);
        memberOrder.setOrderTime(new Date());

        //房间信息
        RoomType roomType = inputVO.getRoomType();
        memberOrder.setRoomType(roomType.ordinal());
        int roomNumber = inputVO.getRoomNumber();
        memberOrder.setRoomNumber(roomNumber);
        memberOrder.setPrice(inputVO.getTotalPrice());

        //联系人信息
        memberOrder.setContactName(inputVO.getContactPersonName());
        memberOrder.setContactPhone(inputVO.getContactPhone());
        memberOrder.setContactEmail(inputVO.getContactEmail());

        memberOrder.setStatus(MemberOrderStatus.Reserved.ordinal());

        memberOrder.setReservedRoomString(strRoomList);

        //保存
        this.orderRepository.save(memberOrder);
    }

}

