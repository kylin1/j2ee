package com.kylin.service.impl;

import com.kylin.service.ManagerStatisticService;
import com.kylin.vo.ManagerHotelStatusVO;
import com.kylin.vo.chart.InOutcomeChartVO;
import com.kylin.vo.chart.ProfitChartVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
@Service
public class ManagerStatisticServiceImpl implements ManagerStatisticService {
    @Override
    public List<ManagerHotelStatusVO> getHotelRoomStatus() {
        return null;
    }

    @Override
    public InOutcomeChartVO getIncomeOutcomeVO() {
        return null;
    }

    @Override
    public ProfitChartVO getProfitVO() {
        return null;
    }
}
