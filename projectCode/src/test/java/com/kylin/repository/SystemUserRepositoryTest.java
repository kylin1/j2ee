package com.kylin.repository;

import com.kylin.model.Hotel;
import com.kylin.model.Member;
import com.kylin.model.SystemUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by kylin on 28/02/2017.
 * All rights reserved.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/test/test-context.xml"})
public class SystemUserRepositoryTest {

    @Autowired
    private SystemUserRepository repository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Test
    public void test(){
        SystemUser user = this.repository.findByAccount("kylin");
        System.out.println(user.getAccount());
        System.out.println(user.getPassword());

        int userId = user.getId();
        Member member = memberRepository.findByUserId(userId);
        System.out.println(member.getId());
        System.out.println(member.getPhone());
    }
    @Test
    public void testHotel(){
        SystemUser user = this.repository.findByAccount("hotel1");
        System.out.println(user.getAccount());
        System.out.println(user.getPassword());

        int userId = user.getId();
        Hotel hotel = hotelRepository.findByUserId(userId);
        System.out.println(hotel.getId());
        System.out.println(hotel.getName());
    }

}
