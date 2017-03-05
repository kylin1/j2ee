package com.kylin.vo.chart;

import java.util.Date;
import java.util.List;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
public class MyChartDataLine {

    //一条数据线
    List<MyChartXYItem> chartXYItemList;

    //起点和终点日期
    private Date startDate;

    private Date endDate;

    //图表上下界
    private int lowBond;

    private int upBond;

    public MyChartDataLine(List<MyChartXYItem> chartXYItemList) {
        this.chartXYItemList = chartXYItemList;
    }

    public MyChartDataLine(List<MyChartXYItem> chartXYItemList, Date startDate, Date endDate, int lowBond, int upBond) {
        this.chartXYItemList = chartXYItemList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.lowBond = lowBond;
        this.upBond = upBond;
    }


    public List<MyChartXYItem> getChartXYItemList() {
        return chartXYItemList;
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
}
