package com.kylin.service.impl;

import com.kylin.model.Member;
import com.kylin.repository.MemberRepository;
import com.kylin.service.MemberService;
import com.kylin.vo.*;
import com.kylin.vo.common.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kylin on 21/02/2017.
 * All rights reserved.
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository repository;

    @Override
    public MemberInfoVO getMemberInfo(int memberId) {
        // get data from dao
        Member member =this.repository.findOne(memberId);
        // return vo to UI
        return new MemberInfoVO(member.getId(),member.getAccount(),member.getPassword());
    }

    @Override
    public List<MemberOrderVO> getOrderList(int memberId) {
        return null;
    }

    @Override
    public List<SearchMemberVO> getOrderHistory(String member) {
        return null;
    }

    @Override
    public MyMessage topUp(int memberId, int amount, int score) {
        return new MyMessage(true,"win win win");
    }

    @Override
    public MyMessage updateInfo(MemberUpdateVO updateVO) {
        return null;
    }
}
