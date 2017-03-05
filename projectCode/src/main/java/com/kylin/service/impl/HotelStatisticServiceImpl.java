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
import com.kylin.tools.myenum.RoomType;
import com.kylin.vo.HotelOrderItemVO;
import com.kylin.vo.HotelRoomStatusVO;
import com.kylin.vo.chart.ChartData;
import com.kylin.vo.chart.HotelIncomeChartVO;
import com.kylin.vo.chart.MyChartDataLine;
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
    public List<HotelOrderItemVO> getOrderList(int hotelId) {
        List<HotelOrderItemVO> result = new ArrayList<>();

        List<MemberOrder> orders = this.orderRepository.findByHotelId(hotelId);
        for (MemberOrder order : orders) {
            RoomType roomType = RoomType.getEnum(order.getRoomType());
            HotelOrderItemVO vo = new HotelOrderItemVO(order.getOrderTime(), roomType, order.getRoomNumber(),
                    order.getCheckIn(), order.getCheckOut(), order.getContactName(), order.getContactPhone());
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
    public HotelIncomeChartVO getIncomeInfo(int hotelId) {
        List<Payment> payments = this.paymentRepository.findByHotelId(hotelId);

        Date endDate = DateHelper.NOW;
        Date startDate = DateHelper.MONTH_AGO;

        ChartData inputData = new ChartData(payments, startDate, endDate);
        MyChartDataLine incomeData = new MyChartDataLine(inputData.getXYList());

        List<MyChartDataLine> data = new ArrayList<>();
        data.add(incomeData);

        HotelIncomeChartVO chartVO = new HotelIncomeChartVO(data);
        return chartVO;
    }
}
