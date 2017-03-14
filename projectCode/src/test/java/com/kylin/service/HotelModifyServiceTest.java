package com.kylin.service;

import com.kylin.tools.myenum.HotelLevel;
import com.kylin.tools.myenum.SystemUserType;
import com.kylin.vo.HotelModifyVO;
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

    private int targetHotelId = 19;


    @Test
    public void testSignUp() {
        MyMessage message = systemUserService.signUp("newh6",
                "123123", SystemUserType.Hotel);
        System.out.println(message);
        int data = (int) message.getData();
        System.out.println("saved id = " + data);
    }

    @Test
    public void testOpenHotel() {
        HotelOpenVO openVO = new HotelOpenVO(targetHotelId,
                "新酒店", "新酒店", HotelLevel.ChainHotel.ordinal());
        MyMessage myMessage = this.service.openHotelRequest(openVO);
        System.out.println(myMessage);
    }

    @Test
    public void testModifyHotel() {
        HotelModifyVO modifyVO = new HotelModifyVO(targetHotelId,"new","new",
                3,"new","new");
        MyMessage myMessage = this.service.modifyHotelRequest(modifyVO);
        System.out.println(myMessage);
    }


    @Test
    public void testGetWaitingRequest() {
        List<RequestVO> requestVOS = this.service.getWaitingRequest(targetHotelId);
        requestVOS.forEach(System.out::println);
    }
}
