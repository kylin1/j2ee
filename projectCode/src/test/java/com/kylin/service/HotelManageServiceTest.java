package com.kylin.service;

import com.kylin.service.myexception.DataIntegrityException;
import com.kylin.tools.DateHelper;
import com.kylin.vo.HotelPlanInputVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/test/test-context.xml"})
public class HotelManageServiceTest {

    @Autowired
    private HotelManageService service;

    @Test
    public void testNewPlan() {
        Date start = DateHelper.getDate(2017, 4, 4);
        Date end = DateHelper.getDate(2017, 4, 6);
        HotelPlanInputVO vo = new HotelPlanInputVO(1, 1, start, end, 200);
        try {
            this.service.makePlan(vo);
        } catch (DataIntegrityException e) {
            e.printStackTrace();
        }
    }

}
