package com.kylin.repository;

import com.kylin.model.HotelRoomStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by kylin on 26/02/2017.
 * All rights reserved.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/test/test-context.xml"})
public class HotelRoomStatusTest {

    @Autowired
    private HotelRoomStatusRepository roomStatusRepository;

    @Test
    public void test(){
        List<HotelRoomStatus> list = roomStatusRepository.findByHotelRoomIdOrderByDateDesc(1);
        for (HotelRoomStatus status: list) {
            System.out.println(status.getDate());
        }
    }
}
