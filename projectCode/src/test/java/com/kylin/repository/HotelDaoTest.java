package com.kylin.repository;

import com.kylin.model.Hotel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by kylin on 17/02/2017.
 * All rights reserved.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/test/test-context.xml"})
public class HotelDaoTest {

    @Autowired
    HotelRepository repository;

    @Test
    public void testGetOne(){
        int hotel = repository.findIdByUserId(500);
        System.out.println(hotel);
    }

    @Test
    public void testInsert(){
        Hotel hotel = new Hotel();
        hotel.setName("tes4t");
        hotel.setLocation("test4");

        repository.save(hotel);
    }

    @Test
    public void testDelete(){
        Hotel hotel = repository.findOne(6);
        repository.delete(hotel);
    }

    @Test
    public void testUpdate(){
        Hotel hotel = repository.findOne(5);

        hotel.setName("new new new");
        repository.save(hotel);
    }

    @Test
    public void testLoc(){
        List<Hotel> hotels = repository.findByLocation("上海");
        System.out.println(hotels.size());
        for (Hotel hotel:hotels){
            System.out.println(hotel.getName());
        }
    }

}
