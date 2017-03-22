package com.kylin.tools;

/**
 * Created by kylin on 15/03/2017.
 * All rights reserved.
 */
public class NumberHelper {

    /**
     * 把数字转换为7位的字符串
     *
     * @param input
     * @return
     */
    public static String getSevenNumber(Integer input) {
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        String str = String.format("%07d", input);
        return str;
    }

    public static void main(String[] args) {
        System.out.println(NumberHelper.getSevenNumber(1003));
    }
}
