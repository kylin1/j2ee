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

    public static Date setTimeToZero(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
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
        result.add(endDate);
        return result;
    }

    public static Date getDate(String stringDate) throws ParseException {
        return dateFormat.parse(stringDate);
    }

    //包含起点终点的天数 4.4-4.6 含有三天
    public static int getDaysNumber(Date from, Date end) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(from);
        long time1 = cal.getTimeInMillis();
        cal.setTime(end);
        long time2 = cal.getTimeInMillis();
        return (int) ((time2 - time1) / (1000 * 3600 * 24)) + 1;
    }
}
