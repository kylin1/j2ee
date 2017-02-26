package com.kylin.tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by kylin on 26/02/2017.
 * All rights reserved.
 */
public class DateHelper {

    public static String getDateString(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    public static Date getDate(int year, int month, int day){
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month-1,day);
        return calendar.getTime();
    }

    public static List<Date> getBetweenDates(Date startDate, Date endDate){
        List<Date> result = new ArrayList<Date>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(startDate);

        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(endDate);
        while (tempStart.before(tempEnd)) {
            result.add(tempStart.getTime());
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Date start = DateHelper.getDate(2017, 4, 4);
        Date end = DateHelper.getDate(2017, 4, 6);
        List<Date> dates = DateHelper.getBetweenDates(start,end);

        for (Date date : dates) {
            System.out.println(date);
        }
//        Date start = DateHelper.getDate(2017, 3, 1);
//        Date end = DateHelper.getDate(2017, 3, 4);
//        System.out.println(DateHelper.getDateString(start));
//        System.out.println(DateHelper.getDateString(end));
    }
}
