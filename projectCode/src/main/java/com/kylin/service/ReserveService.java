package com.kylin.service;

import com.kylin.vo.ReserveInputTableVO;
import com.kylin.vo.SearchHotelItemVO;

import java.util.List;

/**
 * Created by kylin on 20/02/2017.
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
     * @param people
     * @return
     */
    List<SearchHotelItemVO> search(String location, String fromDate, String endDate, int people);

    /**
     * 用户输入预定信息表格完成预定
     *
     * @param reserveInputTableVO
     * @return
     */
    boolean makeReservation(ReserveInputTableVO reserveInputTableVO);
}
