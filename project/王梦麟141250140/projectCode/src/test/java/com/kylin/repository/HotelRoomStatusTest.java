package com.kylin.repository;

import com.kylin.model.HotelRoomStatus;
import com.kylin.model.MemberOrder;
import com.kylin.tools.DateHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
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

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void test(){
        List<HotelRoomStatus> list = roomStatusRepository.findByHotelRoomIdOrderByDateDesc(1);
        for (HotelRoomStatus status: list) {
            System.out.println(status.getDate());
        }
    }


    @Test
    public void test2(){
        Date start = DateHelper.getDate(2017,4,1);
        Date end = DateHelper.getDate(2017,4,2);
        System.out.println(start);
        System.out.println(end);
        List<HotelRoomStatus> list = roomStatusRepository.findByRoomAndDateAndStatus(
                1,start,end,0);
        for (HotelRoomStatus status: list) {
            System.out.println(status.getDate());
            System.out.println(status.getStatus());
        }
    }

    @Test
    public void test3(){
        MemberOrder order = this.orderRepository.findOne(1);
        Date start = DateHelper.setTimeToZero(order.getCheckIn());
        Date end = DateHelper.setTimeToZero(order.getCheckOut());
        System.out.println(start);
        System.out.println(end);
        List<HotelRoomStatus> list = roomStatusRepository.findByRoomAndDateAndStatus(
                1,start,end,0);
        for (HotelRoomStatus status: list) {
            System.out.println(status.getDate());
            System.out.println(status.getStatus());
        }
    }

    @Test
    public void testPrice(){
        Date start = DateHelper.getDate(2017,4,1);
        int roomId = 3;
        int x = this.roomStatusRepository.getPriceByRoomIdAndDate(roomId,start);
        System.out.println(x);
    }
}
