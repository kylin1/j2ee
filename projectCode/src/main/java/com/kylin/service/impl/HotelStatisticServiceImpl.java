package com.kylin.service.impl;

import com.kylin.service.HotelStatisticService;
import com.kylin.vo.HotelOrderItemVO;
import com.kylin.vo.HotelRoomStatusVO;
import com.kylin.vo.chart.HotelIncomeChartVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
@Service
public class HotelStatisticServiceImpl implements HotelStatisticService {
    @Override
    public List<HotelOrderItemVO> getOrderList(int hotelId) {
        return null;
    }

    @Override
    public List<HotelRoomStatusVO> getRoomStatus(int hotelId) {
        return null;
    }

    @Override
    public HotelIncomeChartVO getIncomeInfo(int hotelId) {
        return null;
    }
}
