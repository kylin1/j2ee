package com.kylin.repository;

import com.kylin.model.Hotel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        Hotel hotel = repository.findOne(2);
        System.out.println(hotel.getName());

//        Collection<Approval> approvals = hotel.getApprovals();
//        System.out.println(approvals.size());
    }

    @Test
    public void testInsert(){
        Hotel hotel = new Hotel();
        hotel.setAccount("te4st");
        hotel.setPassword("t4est");
        hotel.setName("tes4t");
        hotel.setLocation("test4");
        hotel.setStatus(99);

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

}
