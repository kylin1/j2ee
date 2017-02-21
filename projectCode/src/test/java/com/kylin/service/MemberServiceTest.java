package com.kylin.service;

import com.kylin.model.Member;
import com.kylin.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by kylin on 21/02/2017.
 * All rights reserved.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:jpa.xml"})
public class MemberServiceTest {

    @Autowired
    private MemberRepository repository;

    @Test
    public void save(){
        Member member = new Member();
        member.setId(3);
        member.setAccount("test");
        member.setPassword("test");
        member.setStatus(0);
        member.setConsume(0);
        member.setBalance(0);
        member.setLevel(0);
        member.setScore(0);
        repository.save(member);
    }

}
