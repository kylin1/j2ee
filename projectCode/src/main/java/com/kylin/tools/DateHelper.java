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

    private static DateFormat dateFormat;
    private static DateFormat dateTimeFormat;

    public static Date START;
    public static Date END;

    public static Date NOW;
    public static Date WEEK_AGO;
    public static Date MONTH_AGO;

    static {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            START = DateHelper.getDate("2017-04-01");
            END = DateHelper.getDate("2017-04-03");
            NOW = new Date();
            NOW = DateHelper.setTimeToZero(NOW);
            WEEK_AGO = DateHelper.addDate(NOW, -7);
            MONTH_AGO = DateHelper.addDate(NOW, -30);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

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

    public static Date setTimeToZero(Date date) {
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

    /**
     * yyyy-MM-dd
     *
     * @param stringDate
     * @return
     * @throws ParseException
     */
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

    //在旧的日期上面增加/减去日期
    public static Date addDate(Date date, int days) {
        Calendar inputC = Calendar.getInstance();
        inputC.setTime(date);
        inputC.add(Calendar.DAY_OF_YEAR, days);
        return inputC.getTime();
    }

    public static String getDateTimeString(Date date) throws ParseException {
        return dateTimeFormat.format(date);
    }

    public static int getDaysNumber(String fromDate, String endDate) {
        Date date1 = null;
        Date date2 = null;

        try {
            date1 = DateHelper.getDate(fromDate);
            date2 = DateHelper.getDate(endDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return DateHelper.getDaysNumber(date1, date2);
    }
}
