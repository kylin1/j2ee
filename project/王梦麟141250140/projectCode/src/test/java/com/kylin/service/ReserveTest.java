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
import java.util.Date;
import java.util.List;

/**
 * Created by kylin on 28/02/2017.
 * All rights reserved.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/test/test-context.xml"})
public class ReserveTest {


    private String start = "2017-04-01";
    private String end = "2017-04-03";

    private Date startDate = DateHelper.getDate(start);
    private Date endDate = DateHelper.getDate(end);

    private int hotelId = 1;
    private int userId = 100;

    private RoomType roomType = RoomType.StandardRoom;

    @Autowired
    private ReserveService service;

    @Autowired
    private HotelManageService manageService;

    public ReserveTest() throws ParseException {

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
        ReserveInputTableVO inputVO = new ReserveInputTableVO(1, hotelId,
                start, end, 1,
                roomNumber, contactPersonName, contactPhone, contactEmail, totalPrice);

        MyMessage myMessage = this.service.makeReservation(inputVO);
        System.out.println(myMessage.isSuccess());
        System.out.println(myMessage.getDisplayMessage());
    }

    @Test
    public void testCancelReservation(){
        int orderId = 1066;
        MyMessage myMessage = this.service.cancelReservation(orderId);
        System.out.println(myMessage);
    }

    @Test
    public void testNonMember(){
        String roomNumber = "101";
        int orderId = 1;
        int hotelId = 24;

        NonMemberCheckInVO nonMemberCheckInVO = new NonMemberCheckInVO();
        nonMemberCheckInVO.setStartDate("2017-03-19");
        nonMemberCheckInVO.setEndDate("2017-03-20");

        nonMemberCheckInVO.setCard1("320322999");
        nonMemberCheckInVO.setGuest1("kylin999");

        nonMemberCheckInVO.setMember(false);
        nonMemberCheckInVO.setIntPaymentType(1);
        nonMemberCheckInVO.setPrice(999);

        nonMemberCheckInVO.setRoomNumber(roomNumber);
        nonMemberCheckInVO.setOrderId(orderId);
        nonMemberCheckInVO.setHotelId(hotelId);

        MyMessage myMessage = this.manageService.reserveNonMember(nonMemberCheckInVO);
        System.out.println(myMessage);
    }
}
