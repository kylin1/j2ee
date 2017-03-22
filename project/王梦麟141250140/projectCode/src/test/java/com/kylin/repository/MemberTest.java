package com.kylin.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by kylin on 12/03/2017.
 * All rights reserved.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/test/test-context.xml"})
public class MemberTest {

    @Autowired
    private MemberRepository repository;

    @Test
    public void test(){
        int id = this.repository.findMemberIdByUserId(100);
        System.out.println(id);
    }
}
