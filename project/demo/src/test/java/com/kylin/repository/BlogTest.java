package com.kylin.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:WEB-INF/app-context.xml"})
public class BlogTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void findB() {
        repository.updateUser("1","1","1","1",1);
    }

}