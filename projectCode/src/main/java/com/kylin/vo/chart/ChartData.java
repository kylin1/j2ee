package com.kylin.vo.chart;

import com.kylin.model.Payment;
import com.kylin.tools.DateHelper;

import java.util.*;

/**
 * Created by kylin on 05/03/2017.
 * All rights reserved.
 */
public class ChartData {

    private List<MyChartXYItem> XYList;

    //最低最高点
    private int lowest;

    private int highest;

    public ChartData(List<Payment> incomeList, Date start, Date end) {
        this.XYList = new ArrayList<>();
        lowest = 0;
        highest = 0;

        // 初始化:目标日期内的每一年数据都是0
        Map<String, Integer> dailyData = new HashMap<>();
        List<String> list = DateHelper.getBetweenDatesString(start, end);
        for (String date : list) {
            dailyData.put(date, 0);
        }

        // 将payment合并为每日的情况
        for (Payment payment : incomeList) {
            Date time = payment.getTime();
            int price = payment.getPrice();
            // 将时间设置为0,按日期汇总
            Date date = DateHelper.setTimeToZero(time);
            String strDate = DateHelper.getDateString(date);
            Integer oldPrice = dailyData.get(strDate);
            // 增加这个日期的价格到数据链中
            Integer newPrice = oldPrice + price;
            dailyData.put(strDate, newPrice);
        }

        // 将目标日期每一天数据加入结果之中
        for (String strDate : list) {
            int data = dailyData.get(strDate);
            MyChartXYItem xyItem = new MyChartXYItem(strDate, data);
            this.XYList.add(xyItem);
            lowest = lowest < data ? lowest : data;
            highest = highest > data ? highest : data;
        }
    }


    public List<MyChartXYItem> getXYList() {
        return XYList;
    }

    @Override
    public String toString() {
        return "ChartData{" +
                "XYList=" + XYList +
                ", lowest=" + lowest +
                ", highest=" + highest +
                '}';
    }

    public int getLowest() {
        return lowest;
    }

    public int getHighest() {
        return highest;
    }
}
