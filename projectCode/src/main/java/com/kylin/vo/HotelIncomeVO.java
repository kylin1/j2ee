package com.kylin.vo;

import java.util.Date;
import java.util.List;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 *
 * 酒店每日收入图表
 */
public class HotelIncomeVO {

    private Date startDate;

    private Date endDate;

    private int lowBond;

    private int upBond;

    private List<HotelIncomeItemVO> incomeItemVOList;

    public HotelIncomeVO(Date startDate, Date endDate, int lowBond, int upBond, List<HotelIncomeItemVO> incomeItemVOList) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.lowBond = lowBond;
        this.upBond = upBond;
        this.incomeItemVOList = incomeItemVOList;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getLowBond() {
        return lowBond;
    }

    public int getUpBond() {
        return upBond;
    }

    public List<HotelIncomeItemVO> getIncomeItemVOList() {
        return incomeItemVOList;
    }
}
