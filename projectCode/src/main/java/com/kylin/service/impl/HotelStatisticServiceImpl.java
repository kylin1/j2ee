package com.kylin.service.impl;

import com.kylin.model.*;
import com.kylin.repository.*;
import com.kylin.service.HotelStatisticService;
import com.kylin.tools.DateHelper;
import com.kylin.tools.myenum.MemberOrderStatus;
import com.kylin.tools.myenum.RoomStatus;
import com.kylin.tools.myenum.RoomType;
import com.kylin.vo.HotelOrderItemVO;
import com.kylin.vo.HotelRoomStatusVO;
import com.kylin.vo.chart.HotelIncomeChartVO;
import com.kylin.vo.chart.MyChart;
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
public class HotelStatisticServiceImpl implements HotelStatisticService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RoomGuestRepository guestRepository;
    @Autowired
    private HotelRoomRepository roomRepository;
    @Autowired
    private HotelRoomStatusRepository statusRepository;

    Date endDate = DateHelper.NOW;
    Date startDate = DateHelper.WEEK_AGO;

    @Override
    //  一个酒店已预订未入住的房客订单
    public List<HotelOrderItemVO> getReservedOrderList(int hotelId) {
        // 订单预定未入住
        int reservedOrderStatus = MemberOrderStatus.Reserved.ordinal();

        List<HotelOrderItemVO> result = new ArrayList<>();

        List<MemberOrder> orders = this.orderRepository.findByHotelIdAndStatus(hotelId, reservedOrderStatus);

        // 对于酒店的每一个预定, 但是还没有入住的订单
        for (MemberOrder order : orders) {
            RoomType roomType = RoomType.getEnum(order.getRoomType());
            String reservedRoomString = order.getReservedRoomString();
            HotelOrderItemVO vo = new HotelOrderItemVO(order.getId(), order.getOrderTime(), roomType, order.getRoomNumber(),
                    reservedRoomString, order.getCheckIn(), order.getCheckOut(), order.getContactName(), order.getContactPhone());
            result.add(vo);
        }
        return result;
    }

    @Override
    public List<HotelRoomStatusVO> getRoomStatus(int hotelId, Date date) {
        List<HotelRoomStatusVO> result = new ArrayList<>();

        // 一个酒店，酒店里面所有房间
        List<HotelRoom> hotelRoomList = this.roomRepository.findByHotelId(hotelId);
        for (HotelRoom room : hotelRoomList) {
            // 一个房间的信息
            String roomNumber = room.getRoomNumber();

            // 获取一个房间一天入住的人数
            int remainNumber = this.getCheckedInNum(room, date);

            // 获取房间的状态
            RoomStatus status = this.getRoomStatusByDate(room, date);

            // 添加每个房间一天的信息
            HotelRoomStatusVO vo = new HotelRoomStatusVO(date, roomNumber, status, remainNumber);
            result.add(vo);
        }

        return result;
    }

    private RoomStatus getRoomStatusByDate(HotelRoom room, Date date) {
        int roomId = room.getId();
        HotelRoomStatus hotelRoomStatus = this.statusRepository.findByRoomAndDate(roomId, date);
        if(hotelRoomStatus == null){
            return RoomStatus.NO_PLAN;
        }
        int intStatus = hotelRoomStatus.getStatus();
        return RoomStatus.getEnum(intStatus);
    }

    /**
     * 一个房间一天,入住的人数
     *
     * @param room
     * @param oneDay
     * @return
     */
    private int getCheckedInNum(HotelRoom room, Date oneDay) {
        int roomId = room.getId();
        List<RoomGuest> guests = this.guestRepository.findByRoomIdAndDate(roomId, oneDay);
        int checkInPeople = guests.size();
        return checkInPeople;
    }

    @Override
    public HotelIncomeChartVO getIncomeInfo(int hotelId, Date startDate, Date endDate) {
        List<Payment> payments = this.paymentRepository.findByHotelId(hotelId);
        return MyChart.getChartVO(payments, startDate, endDate);
    }


}
