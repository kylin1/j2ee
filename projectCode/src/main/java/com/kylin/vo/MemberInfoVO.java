package com.kylin.vo;

import com.kylin.tools.DateHelper;
import com.kylin.tools.myenum.MemberLevel;
import com.kylin.tools.myenum.MemberStatus;

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
    private String name;
    private String phone;
    private String bankCard;
    private String email;

    // activate info
    private MemberStatus status;
    private String strStatus;
    private int intStatus;

    private Date activatedTime;
    private String strActivatedTime;

    private Date expireTime;
    private String strExpireTime;


    // consume amount
    private int totalConsume;

    // 会员卡余额
    private int memberCardRemain;

    private MemberLevel level;
    private String strLevel;

    // 积分
    private int memberScore;

    public MemberInfoVO(int id,String name,String phone,String bankCard,String email, MemberStatus status, Date activatedTime, Date expireTime, int totalConsume, int memberCardRemain, MemberLevel level, int memberScore) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.bankCard = bankCard;
        this.status = status;
        this.activatedTime = activatedTime;
        this.expireTime = expireTime;
        this.totalConsume = totalConsume;
        this.memberCardRemain = memberCardRemain;
        this.level = level;
        this.memberScore = memberScore;
        this.init();
    }

    private void init() {
        this.strActivatedTime = DateHelper.getDateString(this.activatedTime);
        this.strExpireTime = DateHelper.getDateString(this.expireTime);

        this.intStatus = status.getStatus();
        this.strStatus = status.getStringStatus();

        this.strLevel = level.getStringLevel();
    }

    public String getName() {
        return name;
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

    public String getStrStatus() {
        return strStatus;
    }

    public int getIntStatus() {
        return intStatus;
    }

    public String getEmail() {
        return email;
    }

    public String getStrActivatedTime() {
        return strActivatedTime;
    }

    public String getStrExpireTime() {
        return strExpireTime;
    }

    public String getStrLevel() {
        return strLevel;
    }

    public String getPhone() {
        return phone;
    }

    public String getBankCard() {
        return bankCard;
    }
}
