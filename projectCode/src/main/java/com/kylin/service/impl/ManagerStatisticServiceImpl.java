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
    private ExpenditureRepository expenditureRepository;
    @Autowired
    private PaymentRepository paymentRepository;


    private Date start = DateHelper.START;
    private Date end = DateHelper.END;

    @Override
    public List<ManagerHotelStatusVO> getHotelRoomStatus() {
        List<ManagerHotelStatusVO> result = new ArrayList<>();
        List<Hotel> hotelList = this.hotelRepository.findAll();

        List<Date> dateList = DateHelper.getBetweenDates(start, end);

        // 所有酒店
        for (Hotel hotel : hotelList) {
            int hotelId = hotel.getId();
            String hotelName = hotel.getName();

            Map<String, Integer> emptyMap = new ConcurrentHashMap<>();
            Map<String, Integer> busyMap = new ConcurrentHashMap<>();
            for (Date oneDay : dateList) {
                String strDate = DateHelper.getDateString(oneDay);
                emptyMap.put(strDate, 0);
                busyMap.put(strDate, 0);
            }

            // 一个酒店，酒店里面所有房间
            List<HotelRoom> hotelRoomList = this.roomRepository.findByHotelId(hotelId);
            for (HotelRoom room : hotelRoomList) {
                // 一个房间，房间这一周的信息
                int roomId = room.getId();
                List<HotelRoomStatus> roomStatusList = roomStatusRepository.
                        findByRoomAndDate(roomId, this.start, this.end);

                // 所有房间
                for (HotelRoomStatus hotelRoomStatus : roomStatusList) {
                    Date date = hotelRoomStatus.getDate();
                    String strDate = DateHelper.getDateString(date);
                    RoomStatus status = RoomStatus.getEnum(hotelRoomStatus.getStatus());
                    // 空闲
                    if (status == RoomStatus.Empty) {
                        int value = emptyMap.get(strDate);
                        emptyMap.put(strDate, ++value);
                        //不是空闲
                    } else {
                        int value = busyMap.get(strDate);
                        busyMap.put(strDate, ++value);
                    }
                }
            }

            // 按照每一天汇总
            for (Date oneDay : dateList) {
                String strDate = DateHelper.getDateString(oneDay);
                ManagerHotelStatusVO vo = new ManagerHotelStatusVO(oneDay, hotelName,
                        emptyMap.get(strDate), busyMap.get(strDate));
                result.add(vo);
            }
        }
        return result;
    }

    @Override
    public InOutcomeChartVO getIncomeOutcomeVO(Date start, Date end) {
        // 获取数据库数据
        List<Expenditure> outcomeList = this.expenditureRepository.findByDate(start, end);
        List<Payment> incomeList = this.paymentRepository.findByDate(start, end);

        ChartData inputData1 = new ChartData(outcomeList, start, end, 1);
        ChartData inputData2 = new ChartData(incomeList, start, end);

        // 创造两条数据线
        MyChartDataLine outcomeData = new MyChartDataLine(inputData1.getXYList());
        MyChartDataLine incomeData = new MyChartDataLine(inputData2.getXYList());

        // 两条数据线新建图表所有数据
        List<MyChartDataLine> data = new ArrayList<>();
        data.add(outcomeData);
        data.add(incomeData);
        // 返回结果
        InOutcomeChartVO chartVO = new InOutcomeChartVO(data);
        return chartVO;
    }


    @Override
    public ProfitChartVO getProfitVO(Date start, Date end) {
        List<Expenditure> outcomeList = this.expenditureRepository.findAll();
        List<Payment> incomeList = this.paymentRepository.findAll();

        ChartData inputData = new ChartData(incomeList, outcomeList, start, end);
        MyChartDataLine incomeData = new MyChartDataLine(inputData.getXYList());

        List<MyChartDataLine> data = new ArrayList<>();
        data.add(incomeData);

        ProfitChartVO chartVO = new ProfitChartVO(data);
        return chartVO;
    }

    private void addEmptyData(Date start, Date end){
        // TODO 补充没有数据的天数
        List<Date> list = DateHelper.getBetweenDates(start,end);
        for (Date date:list){

        }
    }
}
