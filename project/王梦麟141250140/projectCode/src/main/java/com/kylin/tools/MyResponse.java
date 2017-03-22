package com.kylin.tools;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.kylin.vo.chart.MyChartXYItem;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kylin on 03/12/2016.
 * All rights reserved.
 */
public class MyResponse {

    /**
     * 正确,无参数返回
     *
     * @return JSON数据
     */
    public static String success() {
        return success(null);
    }

    /**
     * 获取数据正常返回json字符串
     *
     * @param data 数据
     * @return JSON数据
     */
    public static String success(Object data) {
        Gson gson = new Gson();
        JsonObject object = new JsonObject();
        JsonElement element = gson.toJsonTree(data);
        object.addProperty("condition", "success");
        object.add("data", element);
        return object.toString();
    }

    public static String toJson(Object data) {
        Gson gson = new Gson();
        JsonObject object = new JsonObject();
        JsonElement element = gson.toJsonTree(data);
        object.add("data", element);
        return object.toString();
    }


    /**
     * 获取数据异常，返回错误提示信息
     *
     * @param message 用户提示信息
     * @param data    数据
     * @return JSON数据
     */
    public static String failure(String message, Object data) {
        JSONObject object = new JSONObject();
        object.put("condition", "fail");
        object.put("message", message);
        object.put("data", data);
        return object.toString();
    }

    /**
     * 获取数据异常，返回错误提示信息
     *
     * @param message 用户提示信息
     * @return JSON数据
     */
    public static String failure(String message) {
        JSONObject object = new JSONObject();
        object.put("condition", "fail");
        object.put("message", message);
        return object.toString();
    }

    /**
     * 目标数据
     * var dataWeightChart =
     * {
     *  labels: ['3月', '4月', '5月', '6月', '7月','8月', '9月', '10月', '11月', '12月'],
     *  series: [
     *      [150, 151, 152, 151, 153,154, 155, 156, 160, 158, 156, 156]
     *  ]
     * };
     *
     * @param paymentChartVO
     * @return
     */
    public static String getChartData(List<MyChartXYItem> paymentChartVO) {
        JSONObject object = new JSONObject();

        // series 是一个两重数组
        JSONArray dataArray = new JSONArray();

        List<String> labelList = new ArrayList<>();
        // 第一层数组
        List<Integer> valueList1 = new ArrayList<>();

        for(MyChartXYItem xyItem:paymentChartVO){
            // 2017-04-01
            String longDate = xyItem.getDate();
            String shortDate = longDate.substring(6,longDate.length());
            labelList.add(shortDate);
            valueList1.add(xyItem.getValue());
        }
        // 第2层数组
        dataArray.put(valueList1);

        object.put("labels",labelList);
        object.put("series",dataArray);

        return object.toString();
    }
}
