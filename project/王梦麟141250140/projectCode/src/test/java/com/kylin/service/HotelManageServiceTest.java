package com.kylin.service;

import com.kylin.tools.DateHelper;
import com.kylin.tools.myenum.RoomType;
import com.kylin.vo.*;
import com.kylin.vo.common.MyMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
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

    private String start = "2017-04-01";
    private String end = "2017-04-03";

    private Date startDate = DateHelper.getDate(start);
    private Date endDate = DateHelper.getDate(end);

    private int hotelId = 1;
    private int hotelRoomId1 = 1;
    private int hotelRoomId2 = 2;
    private int userId = 1;

    private RoomType roomType = RoomType.StandardRoom;

    @Autowired
    private HotelManageService service;

    public HotelManageServiceTest() throws ParseException {

    }

    // hotel测试

    @Test
    public void testNewPlan() {
        int newHotelRoomId = 2;

        HotelPlanInputVO vo = new HotelPlanInputVO(hotelId,"", newHotelRoomId,
                "2017-04-13", "2017-4-15", 220);
        MyMessage myMessage = this.service.makePlan(vo);
        System.out.println(myMessage);
    }

    @Test
    public void testGetPlan(){
        List<HotelPlanVO> planVOS = this.service.getHotelPlan(hotelId);
        planVOS.forEach(System.out::println);
    }

    @Test
    public void testCheckIn() {
        int orderId = 9;
        int roomId = 1;
        int roomId2 = 2;

        List<HotelRoomCheckIn> list = new ArrayList<>();
        //入住两个房间
        List<HotelGuestCheckIn> guestCheckIns = new ArrayList<>();
        guestCheckIns.add(new HotelGuestCheckIn("kylin1", "320311"));
        guestCheckIns.add(new HotelGuestCheckIn("kylin2", "320322"));
        HotelRoomCheckIn hotelRoomCheckIn1 = new HotelRoomCheckIn(roomId, guestCheckIns);

        List<HotelGuestCheckIn> guestCheckIns2 = new ArrayList<>();
        guestCheckIns2.add(new HotelGuestCheckIn("kylin3", "320333"));
        guestCheckIns2.add(new HotelGuestCheckIn("kylin4", "320344"));
        HotelRoomCheckIn hotelRoomCheckIn2 = new HotelRoomCheckIn(roomId2, guestCheckIns2);

        list.add(hotelRoomCheckIn1);


        //添加入住信息
        HotelCheckInTableVO vo = new HotelCheckInTableVO();
        vo.setHotelRoomCheckInList(list);

        MyMessage myMessage = this.service.customCheckIn(vo);
        System.out.println(myMessage.isSuccess());
        System.out.println(myMessage.getDisplayMessage());

    }


}
