package com.kylin.vo.chart;

import com.kylin.model.Payment;

import java.util.ArrayList;
import java.util.Date;
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

    @Override
    public String toString() {
        return "MyChart{" +
                "chartData=" + chartData +
                ", charLineNumber=" + charLineNumber +
                '}';
    }

    public static HotelIncomeChartVO getChartVO(List<Payment> payments, Date startDate, Date endDate) {
        ChartData inputData = new ChartData(payments, startDate, endDate);
        int lowest = (int) (inputData.getLowest() * 0.8);
        int highest = (int) (inputData.getHighest() * 1.2);

        MyChartDataLine incomeData = new MyChartDataLine(inputData.getXYList(), startDate, endDate,
                lowest, highest);

        List<MyChartDataLine> data = new ArrayList<>();
        data.add(incomeData);

        HotelIncomeChartVO chartVO = new HotelIncomeChartVO(data);
        return chartVO;
    }
}
