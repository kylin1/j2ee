package com.kylin.service;

import com.kylin.vo.HotelStatusVO;
import com.kylin.vo.IncomeOutcomeVO;
import com.kylin.vo.ProfitVO;

import java.util.List;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 */
public interface ManagerStatisticService {

    /**
     * 得到各店入住情况
     *
     * @return
     */
    List<HotelStatusVO> getHotelRoomStatus();

    /**
     * 收入/支出折线图
     *
     * @return
     */
    IncomeOutcomeVO getIncomeOutcomeVO();

    /**
     * 利润柱状图
     *
     * @return
     */
    ProfitVO getProfitVO();

}
