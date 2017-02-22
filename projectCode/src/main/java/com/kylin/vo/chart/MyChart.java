package com.kylin.vo.chart;

import java.util.List;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
public class MyChart {

    /**
     * 一个图表会有几条数据线
     * <p>
     * 每一条数据线都是一个x,y的list
     */
    private List<MyChartDataLine> chartData;

    //图表有多少条数据线
    private int charLineNumber;

    public MyChart(List<MyChartDataLine> chartData) {
        this.chartData = chartData;
        this.charLineNumber = chartData.size();
    }

    public List<MyChartDataLine> getChartData() {
        return chartData;
    }

    public int getCharLineNumber() {
        return charLineNumber;
    }
}
