package com.kylin.vo.chart;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
public class MyChartXYItem {

    // x:date
    private String date;

    // y:value
    private int value;

    public MyChartXYItem(String date, int value) {
        this.date = date;
        this.value = value;
    }

    public String getDate() {
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
