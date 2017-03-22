package com.kylin.service;

import com.kylin.tools.myenum.RoomType;
import com.kylin.vo.HotelModifyVO;
import com.kylin.vo.HotelOpenVO;
import com.kylin.vo.RequestVO;
import com.kylin.vo.common.MyMessage;

import java.util.List;

/**
 * Created by kylin on 09/03/2017.
 * All rights reserved.
 *
 * 开店申请，修改酒店信息的接口
 */
public interface HotelModifyService {

    /**
     * 酒店注册账号之后，完善酒店信息，然后申请开店
     *
     * @param openVO
     * @return
     */
    MyMessage openHotelRequest(HotelOpenVO openVO);


    /**
     * 酒店申请修改自己的信息，需要等待审批结束之后才能执行修改
     * 新的信息暂时缓存到临时表中
     * 经理审批结束之后再写入真正的表
     *
     * @param modifyVO
     * @return
     */
    MyMessage modifyHotelRequest(HotelModifyVO modifyVO);


    /**
     * 添加房间
     *
     * @return
     */
    MyMessage addRoom(int hotelId, RoomType roomType, String roomNumber, String roomInfo);

    /**
     * 获取没有审批的信息
     *
     * @return
     */
    List<RequestVO> getWaitingRequest(int hotelId);

    /**
     * 获取审批通过的信息
     *
     * @return
     */
    List<RequestVO> getPassedRequest(int hotelId);


    /**
     * 获取审批拒绝的信息
     *
     * @return
     */
    List<RequestVO> getDeniedRequest(int hotelId);


}

