package com.kylin.service;

import com.kylin.service.myexception.BadInputException;
import com.kylin.service.myexception.DataIntegrityException;
import com.kylin.tools.DateHelper;
import com.kylin.vo.*;
import com.kylin.vo.myenum.PaymentType;
import com.kylin.vo.myenum.RoomType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/test/test-context.xml"})
public class HotelManageServiceTest {

    @Autowired
    private HotelManageService service;

    @Test
    public void testNewPlan() {
        Date start = DateHelper.getDate(2017, 4, 4);
        Date end = DateHelper.getDate(2017, 4, 6);
        HotelPlanInputVO vo = new HotelPlanInputVO(1, 1, start, end, 200);
        try {
            this.service.makePlan(vo);
        } catch (DataIntegrityException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetPlan() {
        List<HotelPlanVO> planVOS = this.service.getHotelPlan(1);
        for (HotelPlanVO v : planVOS) {

        }
    }

    @Test
    public void testHotelSearch() {
        String start = "2017-04-02";
        String end = "2017-04-05";
        List<HotelRemainRoom> remainRooms = this.service.hotelRoomSearch(
                1, start, end, RoomType.StandardRoom);
        for (HotelRemainRoom remainRoom : remainRooms) {
            System.out.println(remainRoom.getRoom());
            System.out.println(remainRoom.getInformation());
        }
    }

    @Test
    public void testCheckIn() {
        List<HotelRoomCheckIn> list = new ArrayList<>();
        //入住两个房间
        List<HotelGuestCheckIn> guestCheckIns = new ArrayList<>();
        guestCheckIns.add(new HotelGuestCheckIn("kylin1", "320311"));
        guestCheckIns.add(new HotelGuestCheckIn("kylin2", "320322"));
        HotelRoomCheckIn hotelRoomCheckIn1 = new HotelRoomCheckIn(1, guestCheckIns);

        List<HotelGuestCheckIn> guestCheckIns2 = new ArrayList<>();
        guestCheckIns2.add(new HotelGuestCheckIn("kylin3", "320333"));
        guestCheckIns2.add(new HotelGuestCheckIn("kylin4", "320344"));
        HotelRoomCheckIn hotelRoomCheckIn2 = new HotelRoomCheckIn(3, guestCheckIns2);

        list.add(hotelRoomCheckIn1);
        list.add(hotelRoomCheckIn2);
        //添加入住信息
        HotelCheckInTableVO vo = new HotelCheckInTableVO(1, 1, list,
                true, PaymentType.Cash);
        try {
            this.service.customCheckIn(vo);
        } catch (BadInputException e) {
            e.printStackTrace();
        }
    }


}
