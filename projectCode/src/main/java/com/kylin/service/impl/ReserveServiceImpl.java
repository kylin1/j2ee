package com.kylin.service.impl;

import com.kylin.repository.HotelRepository;
import com.kylin.service.ReserveService;
import com.kylin.vo.ReserveInputTableVO;
import com.kylin.vo.SearchHotelItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
@Service
public class ReserveServiceImpl implements ReserveService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<SearchHotelItemVO> search(String location, String fromDate, String endDate, int people) {
        return null;
    }

    @Override
    public boolean makeReservation(ReserveInputTableVO reserveInputTableVO) {
        return false;
    }
}
