package com.kylin.service;

import com.kylin.vo.ReserveDetailVO;
import com.kylin.vo.ReserveInputVO;
import com.kylin.vo.ReserveItemVO;

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
    List<ReserveItemVO> search(String location, String fromDate, String endDate, int people);

    /**
     * 用户从酒店列表里面选取一个目标酒店
     * 获取该酒店的详细信息
     *
     * @param hotelId
     * @param fromDate
     * @param endDate
     * @return
     */
    ReserveDetailVO reserveDetail(int hotelId, String fromDate, String endDate);

    /**
     * 用户输入预定信息表格完成预定
     *
     * @param reserveInputVO
     * @return
     */
    boolean makeReservation(ReserveInputVO reserveInputVO);
}
