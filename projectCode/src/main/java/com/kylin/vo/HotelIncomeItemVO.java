package com.kylin.vo;

import java.util.Date;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 *
 * 酒店每日收入图表上面一天的数据
 */
public class HotelIncomeItemVO {

    private Date date;

    private int incomeAmount;

    public HotelIncomeItemVO(Date date, int incomeAmount) {
        this.date = date;
        this.incomeAmount = incomeAmount;
    }

    public Date getDate() {
        return date;
    }

    public int getIncomeAmount() {
        return incomeAmount;
    }
}
