package com.kylin.vo;

import com.kylin.vo.myenum.MemberLevel;
import com.kylin.vo.myenum.MemberStatus;

import java.util.Date;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 *
 * 会员界面查看的会员卡信息
 *
 */
public class MemberInfoVO {

    // id and account
    private int id;

    // activate info
    private MemberStatus status;

    private Date activatedTime;

    private Date expireTime;

    // consume amount
    private int totalConsume;

    // 会员卡余额
    private int memberCardRemain;

    private MemberLevel level;

    // 积分
    private int memberScore;

    public MemberInfoVO(int id, MemberStatus status, Date activatedTime, Date expireTime, int totalConsume, int memberCardRemain, MemberLevel level, int memberScore) {
        this.id = id;
        this.status = status;
        this.activatedTime = activatedTime;
        this.expireTime = expireTime;
        this.totalConsume = totalConsume;
        this.memberCardRemain = memberCardRemain;
        this.level = level;
        this.memberScore = memberScore;
    }

    public int getId() {
        return id;
    }

    public MemberStatus getStatus() {
        return status;
    }

    public Date getActivatedTime() {
        return activatedTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public int getTotalConsume() {
        return totalConsume;
    }

    public int getMemberCardRemain() {
        return memberCardRemain;
    }

    public MemberLevel getLevel() {
        return level;
    }

    public int getMemberScore() {
        return memberScore;
    }
}
