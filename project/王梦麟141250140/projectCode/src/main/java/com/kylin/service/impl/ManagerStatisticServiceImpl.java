package com.kylin.service.impl;

import com.kylin.model.*;
import com.kylin.repository.*;
import com.kylin.service.ManagerStatisticService;
import com.kylin.tools.DateHelper;
import com.kylin.tools.myenum.RoomStatus;
import com.kylin.vo.ManagerHotelStatusVO;
import com.kylin.vo.chart.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
@Service
public class ManagerStatisticServiceImpl implements ManagerStatisticService {

    @Autowired
    private HotelRoomStatusRepository roomStatusRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private HotelRoomRepository roomRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    private Date start = DateHelper.START;
    private Date end = DateHelper.TOMORROW;

    @Override
    public List<ManagerHotelStatusVO> getHotelRoomStatus(Date date) {
        String strDate = DateHelper.getDateString(date);

        List<ManagerHotelStatusVO> result = new ArrayList<>();
        List<Hotel> hotelList = this.hotelRepository.findAll();

        // 所有酒店
        for (Hotel hotel : hotelList) {
            int hotelId = hotel.getId();
            String hotelName = hotel.getName();

            Map<String, Integer> emptyMap = new ConcurrentHashMap<>();
            Map<String, Integer> busyMap = new ConcurrentHashMap<>();
            Map<String, Integer> notAvailMap = new ConcurrentHashMap<>();

            emptyMap.put(strDate,0);
            busyMap.put(strDate,0);
            notAvailMap.put(strDate,0);

            // 一个酒店，酒店里面所有房间
            List<HotelRoom> hotelRoomList = this.roomRepository.findByHotelId(hotelId);
            for (HotelRoom room : hotelRoomList) {
                // 一个房间，房间这天的信息
                int roomId = room.getId();
                HotelRoomStatus hotelRoomStatus = roomStatusRepository.
                        findByRoomAndDate(roomId, date);
                RoomStatus status;

                // 如果这个房间这一天没有计划
                if (hotelRoomStatus == null) {
                    status = RoomStatus.NO_PLAN;
                } else {
                    //这个房间有计划
                    status = RoomStatus.getEnum(hotelRoomStatus.getStatus());
                }

                //没有计划,不可用
                if (status == RoomStatus.NO_PLAN || status == RoomStatus.NotAvailable) {
                    int value = notAvailMap.get(strDate);
                    notAvailMap.put(strDate, ++value);
                    // 空闲
                } else if (status == RoomStatus.Empty) {
                    int value = emptyMap.get(strDate);
                    emptyMap.put(strDate, ++value);
                    //不是空闲
                } else {
                    int value = busyMap.get(strDate);
                    busyMap.put(strDate, ++value);
                }
            }
            // 添加一个酒店
            ManagerHotelStatusVO vo = new ManagerHotelStatusVO(date, hotelName,
                    emptyMap.get(strDate), busyMap.get(strDate), notAvailMap.get(strDate));
            result.add(vo);
        }
        return result;
    }

    @Override
    public HotelIncomeChartVO getPaymentChartVO(Date start, Date end) {
        // 获取数据库数据,时间升序
        List<Payment> incomeList = this.paymentRepository.findByDate(start, end);
        return MyChart.getChartVO(incomeList, start, end);
    }
}
