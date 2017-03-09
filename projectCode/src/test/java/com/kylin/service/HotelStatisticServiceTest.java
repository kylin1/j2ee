package com.kylin.service;

import com.kylin.vo.HotelRoomStatusVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by kylin on 22/02/2017
 * All rights reserved.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/test/test-context.xml"})
public class HotelStatisticServiceTest {

    @Autowired
    private HotelStatisticService service;

    @Test
    public void test(){
        List<HotelRoomStatusVO> list = this.service.getRoomStatus(1);
        for(HotelRoomStatusVO roomStatusVO:list){
            System.out.println(roomStatusVO);
        }
    }

}
