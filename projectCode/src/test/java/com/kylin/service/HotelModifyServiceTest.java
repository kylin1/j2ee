package com.kylin.service;

import com.kylin.tools.myenum.HotelLevel;
import com.kylin.tools.myenum.SystemUserType;
import com.kylin.vo.HotelOpenVO;
import com.kylin.vo.RequestVO;
import com.kylin.vo.common.MyMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/test/test-context.xml"})
public class HotelModifyServiceTest {

    @Autowired
    private SystemUserService systemUserService;
    @Autowired
    private HotelModifyService service;

    @Test
    public void testOpenHotel() {
        MyMessage message = systemUserService.signUp("newhotel4", "123123", SystemUserType.Hotel);
        System.out.println(message);
        int data = (int) message.getData();
        System.out.println("saved id = " + data);

        int userId = data;
        HotelOpenVO openVO = new HotelOpenVO(userId, "新酒店", "上海新世界", HotelLevel.ChainHotel.ordinal());
        MyMessage myMessage = this.service.openHotelRequest(openVO);
        System.out.println(myMessage);
        int hotelId = (int) myMessage.getData();
        System.out.println("hotelId = " + hotelId);
    }

    @Test
    public void testModifyHotel() {

    }


    @Test
    public void testGetWaitingRequest() {
        int hotelId = 11;
        List<RequestVO> requestVOS = this.service.getWaitingRequest(hotelId);
        requestVOS.forEach(System.out::println);
    }
}
