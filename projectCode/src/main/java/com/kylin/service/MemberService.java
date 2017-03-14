package com.kylin.service;

import com.kylin.tools.myexception.NotFoundException;
import com.kylin.vo.*;
import com.kylin.vo.common.MyMessage;

import java.util.List;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 */
public interface MemberService {


    /**
     * 获取会员卡信息
     *
     * @param memberId
     * @return
     */
    MemberInfoVO getMemberInfo(int memberId);

    MemberInfoVO getMemberInfoByUserId(int userId);

    /**
     * 获取用户的订单历史
     *
     * @param memberId
     * @return
     */
    List<MemberOrderVO> getOrderList(int memberId);

    /**
     * 输入会员姓名/账号进行查询
     *
     * @param member
     * @return
     */
    List<SearchMemberVO> getOrderHistory(String member) throws NotFoundException;

    /**
     * 会员充值
     *
     * @param memberId
     * @param amount 金额
     * @param score 使用多少积分抵用
     * @return
     */
    MyMessage topUp(int memberId, int amount, int score);

    /**
     * 修改个人信息
     *
     * @return
     */
    MyMessage updateInfo(MemberUpdateTableVO updateVO);

}
