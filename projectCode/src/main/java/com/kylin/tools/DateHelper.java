package com.kylin.tools;

import java.text.DateFormat;
import java.text.ParseException;
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

    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static String getDateString(Date date) {
        return dateFormat.format(date);
    }

    public static Date getDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static List<Date> getBetweenDates(Date startDate, Date endDate) {
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
        int days = DateHelper.getDaysNumber(start, end);
        System.out.println(days);

        try {
            Date date = DateHelper.getDate("2017-04-2");
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static Date getDate(String endDate) throws ParseException {
        return dateFormat.parse(endDate);
    }

    //包含起点终点的天数
    public static int getDaysNumber(Date from, Date end) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(from);
        long time1 = cal.getTimeInMillis();
        cal.setTime(end);
        long time2 = cal.getTimeInMillis();
        return (int) ((time2 - time1) / (1000 * 3600 * 24)) + 1;
    }
}
