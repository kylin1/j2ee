package com.kylin.vo.chart;

import com.kylin.model.Payment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kylin on 05/03/2017.
 * All rights reserved.
 */
public class ChartData {


    private List<MyChartXYItem> XYList;

    public ChartData(List<Payment> incomeList, Date start, Date end) {
        this.XYList = new ArrayList<>();
        for (Payment payment : incomeList) {
            Date x = payment.getTime();
            int y = payment.getPrice();
            MyChartXYItem xyItem = new MyChartXYItem(x, y);
            this.XYList.add(xyItem);
        }
    }


    public List<MyChartXYItem> getXYList() {
        return XYList;
    }

    @Override
    public String toString() {
        return "ChartData{" +
                "XYList=" + XYList +
                '}';
    }
}
