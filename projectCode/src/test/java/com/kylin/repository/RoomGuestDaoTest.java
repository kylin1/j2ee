package com.kylin.repository;

import com.kylin.model.HotelRoom;
import com.kylin.model.RoomGuest;
import com.kylin.model.MemberOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by kylin on 27/02/2017.
 * All rights reserved.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/test/test-context.xml"})
public class RoomGuestDaoTest {

    @Autowired
    private RoomGuestRepository repository;


    @Autowired
    private OrderRepository orderRepository;


    @Autowired
    private HotelRoomRepository roomRepository;

    @Test
    public void test(){
        RoomGuest roomGuest = new RoomGuest();
        roomGuest.setDate(new Date());
        roomGuest.setName("kylin");
        roomGuest.setIdNum("320322");

        MemberOrder order = orderRepository.findOne(1);
        HotelRoom room = roomRepository.findOne(1);
        roomGuest.setOrderId(order.getId());
        roomGuest.setRoomByRoomId(room);

        this.repository.save(roomGuest);
    }
}
