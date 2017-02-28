package com.kylin.service.impl;

import com.kylin.model.Member;
import com.kylin.repository.MemberRepository;
import com.kylin.service.MemberService;
import com.kylin.vo.MemberInfoVO;
import com.kylin.vo.MemberOrderVO;
import com.kylin.vo.MemberUpdateTableVO;
import com.kylin.vo.SearchMemberVO;
import com.kylin.vo.common.MyMessage;
import com.kylin.tools.myenum.MemberLevel;
import com.kylin.tools.myenum.MemberStatus;
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
        Member entity = this.repository.findOne(memberId);

        // get enums
        MemberStatus memberStatus = MemberStatus.getEnum(entity.getStatus());
        MemberLevel memberLevel = MemberLevel.getEnum(entity.getLevel());

        MemberInfoVO memberInfoVO = new MemberInfoVO(memberId,
                memberStatus,entity.getActivatedTime(),entity.getExpireTIme(),
                entity.getConsume(),entity.getBalance(),memberLevel,entity.getScore());

        return memberInfoVO;
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
    public MyMessage updateInfo(MemberUpdateTableVO updateVO) {
        return null;
    }
}
