package com.kylin.vo.chart;

import java.util.Date;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
public class MyChartXYItem {

    // x:date
    private Date date;

    // y:value
    private int value;

    public MyChartXYItem(Date date, int value) {
        this.date = date;
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "MyChartXYItem{" +
                "date=" + date +
                ", value=" + value +
                '}';
    }
}
