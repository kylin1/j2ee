package com.kylin.repository;

import com.kylin.model.HotelRoom;
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
public class HotelRoomTest {

    @Autowired
    private HotelRoomRepository repository;

    @Test
    public void test(){
        List<HotelRoom> integers = repository.findByHotelId(1);
        System.out.println(integers.size());
    }
}
