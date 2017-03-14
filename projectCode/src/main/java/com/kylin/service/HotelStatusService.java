package com.kylin.service;

import com.kylin.vo.common.MyMessage;

/**
 * Created by kylin on 14/03/2017.
 * All rights reserved.
 */
public interface HotelStatusService {

    /**
     * 判断一个酒店是否通过了开店申请
     *
     * @param hotelId 酒店ID
     * @return isSuccess代表是否开店完成
     */
    MyMessage isHotelOpened(int hotelId);

}
