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
        int newHotelRoomId = 6;
        HotelPlanInputVO vo = new HotelPlanInputVO(hotelId, newHotelRoomId,
                startDate, endDate, 200);
        try {
            this.service.makePlan(vo);
        } catch (DataIntegrityException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetPlan() {
        List<HotelPlanVO> planVOS = this.service.getHotelPlan(hotelId);
        for (HotelPlanVO v : planVOS) {
            System.out.println(v.getRoom());
            System.out.println(v.getStartDate());
            System.out.println(v.getEndDate());
        }
    }

    @Test
    public void testHotelSearch() {
        //搜索一个酒店内部剩余的房间
        List<HotelRemainRoom> remainRooms = this.service.emptyRoomSearch(
                hotelId, start, end, RoomType.StandardRoom);
        for (HotelRemainRoom remainRoom : remainRooms) {
            System.out.println(remainRoom.getRoom());
            System.out.println(remainRoom.getInformation());
        }
    }

    //用户测试
    @Test
    public void testSearch() {
        List<SearchHotelItemVO> searchHotelItemVOS = this.service.search("上海",
                start, end, RoomType.StandardRoom.ordinal(), 2);
        for (SearchHotelItemVO vo : searchHotelItemVOS) {
            System.out.println(vo.getHotelName());
            List<RemainRoomInfo> remainRoomNumber = vo.getRemainRoomNumber();
            for (RemainRoomInfo remainRoomInfo : remainRoomNumber) {
                System.out.println(remainRoomInfo.getRoomType());
                System.out.println(remainRoomInfo.getRemainNumber());
                System.out.println(remainRoomInfo.getPricePerNight());
            }
        }
    }

    @Test
    public void testMakeReservation() {
        int roomNumber = 2;

        String contactPersonName = "kylin test 222";
        String contactPhone = "187";
        String contactEmail = "email";

        int totalPrice = 666;
        ReserveInputTableVO inputVO = new ReserveInputTableVO(userId, hotelId, startDate, endDate,
                roomType, roomNumber, contactPersonName, contactPhone, contactEmail, totalPrice);

        this.service.makeReservation(inputVO);
    }

    @Test
    public void testCheckIn() {
        List<HotelRoomCheckIn> list = new ArrayList<>();
        //入住两个房间
        List<HotelGuestCheckIn> guestCheckIns = new ArrayList<>();
        guestCheckIns.add(new HotelGuestCheckIn("kylin1", "320311"));
        guestCheckIns.add(new HotelGuestCheckIn("kylin2", "320322"));
        HotelRoomCheckIn hotelRoomCheckIn1 = new HotelRoomCheckIn(2, guestCheckIns);

        List<HotelGuestCheckIn> guestCheckIns2 = new ArrayList<>();
        guestCheckIns2.add(new HotelGuestCheckIn("kylin3", "320333"));
        guestCheckIns2.add(new HotelGuestCheckIn("kylin4", "320344"));
        HotelRoomCheckIn hotelRoomCheckIn2 = new HotelRoomCheckIn(5, guestCheckIns2);

        list.add(hotelRoomCheckIn1);
        list.add(hotelRoomCheckIn2);

        int orderId = 3;

        //添加入住信息
        HotelCheckInTableVO vo = new HotelCheckInTableVO(hotelId, orderId, list, true, PaymentType.Cash);
        try {
            this.service.customCheckIn(vo);
        } catch (BadInputException e) {
            e.printStackTrace();
        }
    }


}
