package com.kylin.service;

import com.kylin.tools.myenum.MemberLevel;
import com.kylin.tools.myenum.RoomType;
import com.kylin.vo.HotelRemainRoom;
import com.kylin.vo.ReserveInputTableVO;
import com.kylin.vo.SearchHotelItemVO;
import com.kylin.vo.common.MyMessage;

import java.util.List;

/**
 * Created by kylin on 28/02/2017.
 * All rights reserved.
 */
public interface ReserveService {

    /**
     * 搜索目标地点、日期、人数的酒店信息
     * 返回符合条件的酒店列表
     *
     * @param location
     * @param fromDate
     * @param endDate
     * @param roomTypeInt
     * @param roomNumber
     * @return
     */
    List<SearchHotelItemVO> search(String location, String fromDate, String endDate,
                                   int roomTypeInt, int roomNumber);


    /**
     * 用户输入预定信息表格完成预定
     *
     * @param reserveInputTableVO
     * @return
     */
    MyMessage makeReservation(ReserveInputTableVO reserveInputTableVO);

    /**
     * 酒店管理人员搜索空闲房间，给客户分配
     *
     * @param fromDate
     * @param endDate
     * @param roomType
     * @return
     */
    List<HotelRemainRoom> emptyRoomSearch(int hotelId, String fromDate, String endDate, RoomType roomType);


    /**
     * 根据订单总价格 和 用户等级计算折扣
     *
     * @param price
     * @param level
     * @return
     */
    int getDiscount(int price, MemberLevel level);
}
