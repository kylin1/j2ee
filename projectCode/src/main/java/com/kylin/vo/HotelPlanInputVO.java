package com.kylin.vo;

import java.util.Date;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 *
 * 一个房间的入住计划
 */
public class HotelPlanInputVO {

    private int hotelId;

    // 房间ID
    private int hotelRoomId;

    // date info
    private Date checkInDate;

    private Date checkOutDate;

    //每日每晚价格
    private int price;

   
}
