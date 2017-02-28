package com.kylin.util;

import com.kylin.tools.DateHelper;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by kylin on 27/02/2017.
 * All rights reserved.
 */
public class DateTest {


    private String start = "2017-04-01";
    private String end = "2017-04-03";

    private Date startDate = DateHelper.getDate(start);
    private Date endDate = DateHelper.getDate(end);

    public DateTest() throws ParseException {
    }


    @Test
    public void test(){
        List<Date> dates = DateHelper.getBetweenDates(startDate,endDate);
        for(Date date:dates){
            System.out.println(date);
        }
    }

    @Test
    public void testAdd(){
        Date old = new Date();
        Date newx = DateHelper.addDate(old,365);
        System.out.println(old);
        System.out.println(newx);
    }

}
