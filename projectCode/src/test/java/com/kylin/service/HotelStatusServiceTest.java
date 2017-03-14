package com.kylin.service;

import com.kylin.vo.common.MyMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by kylin on 14/03/2017.
 * All rights reserved.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/test/test-context.xml"})
public class HotelStatusServiceTest {

    @Autowired
    private HotelStatusService statusService;

    private int hotelId = 1;

    @Test
    public void testOpen(){
        MyMessage myMessage = this.statusService.isHotelOpened(hotelId);
        System.out.println(myMessage);
    }
}
