package com.kylin.service.impl;

import com.kylin.model.HotelRoom;
import com.kylin.model.MemberOrder;
import com.kylin.model.Payment;
import com.kylin.model.RoomGuest;
import com.kylin.repository.HotelRoomRepository;
import com.kylin.repository.OrderRepository;
import com.kylin.repository.PaymentRepository;
import com.kylin.repository.RoomGuestRepository;
import com.kylin.service.HotelStatisticService;
import com.kylin.tools.DateHelper;
import com.kylin.tools.myenum.MemberOrderStatus;
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
    public List<HotelRoomStatusVO> getRoomStatus(int hotelId) {
        List<HotelRoomStatusVO> result = new ArrayList<>();
        Date endDate = DateHelper.NOW;
        Date startDate = DateHelper.WEEK_AGO;

        // 一个酒店，酒店里面所有房间
        List<HotelRoom> hotelRoomList = this.roomRepository.findByHotelId(hotelId);
        for (HotelRoom room : hotelRoomList) {

            // 一个房间的信息
            String roomNumber = room.getRoomNumber();

            List<Date> dateList = DateHelper.getBetweenDates(startDate, endDate);
            for (Date oneDay : dateList) {
                // 获取一个房间一天入住的人数
                int remainNumber = this.getCheckedInNum(room, oneDay);

                // 添加每个房间一天的信息
                HotelRoomStatusVO vo = new HotelRoomStatusVO(oneDay, roomNumber, remainNumber);
                result.add(vo);
            }
        }

        return result;
    }

    private int getCheckedInNum(HotelRoom room, Date oneDay) {
        int roomId = room.getId();
        List<RoomGuest> guests = this.guestRepository.findByRoomIdAndDate(roomId, oneDay);
        int checkInPeople = guests.size();
        return checkInPeople;
    }

    @Override
    public HotelIncomeChartVO getIncomeInfo(int hotelId, Date startDate, Date endDate) {
        List<Payment> payments = this.paymentRepository.findByHotelId(hotelId);
        return MyChart.getChartVO(payments,startDate,endDate);
    }


}
