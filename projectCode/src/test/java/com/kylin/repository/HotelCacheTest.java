package com.kylin.repository;

import com.kylin.model.HotelCache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by kylin on 10/03/2017.
 * All rights reserved.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/test/test-context.xml"})
public class HotelCacheTest {

    @Autowired
    private HotelCacheRepository repository;

    @Test
    public void testFindByIsPassed(){
        List<HotelCache> list = repository.findByStatus(0);
        list.forEach(System.out::println);
    }

    @Test
    public void testFindByUserIdAndStatus(){
        List<HotelCache> list = repository.findByUserIdAndStatus(500,1);
        list.forEach(System.out::println);
    }
}
