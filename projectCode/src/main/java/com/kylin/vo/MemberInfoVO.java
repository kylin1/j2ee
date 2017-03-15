package com.kylin.vo;

import com.kylin.tools.DateHelper;
import com.kylin.tools.myenum.MemberLevel;

import java.util.Date;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 *
 * 会员界面查看的会员卡信息
 *
 */
public class MemberInfoVO {

    private String carNumber;

    // id and account
    private int id;
    private String name;
    private String phone;
    private String bankCard;
    private String email;

    // activate info
    private String strStatus;

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

    public MemberInfoVO(String carNumber,int id,String name,String phone,String bankCard,String email, String status, Date activatedTime, Date expireTime, int totalConsume, int memberCardRemain, MemberLevel level, int memberScore) {
        this.carNumber = carNumber;
        this.strStatus = status;
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.bankCard = bankCard;
        this.activatedTime = activatedTime;
        this.expireTime = expireTime;
        this.totalConsume = totalConsume;
        this.memberCardRemain = memberCardRemain;
        this.level = level;
        this.memberScore = memberScore;
        this.init();
    }

    public String getCarNumber() {
        return carNumber;
    }

    private void init() {
        this.strActivatedTime = DateHelper.getDateString(this.activatedTime);
        this.strExpireTime = DateHelper.getDateString(this.expireTime);

        this.strLevel = level.getStringLevel();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
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

    /**
     * 账户现在是否是激活的状态
     * 过期时间在当前时间之后
     *
     * @return
     */
    public boolean isActivating(){
        return this.expireTime.after(new Date());
    }

    @Override
    public String toString() {
        return "MemberInfoVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", bankCard='" + bankCard + '\'' +
                ", email='" + email + '\'' +
                ", strStatus='" + strStatus + '\'' +
                ", activatedTime=" + activatedTime +
                ", strActivatedTime='" + strActivatedTime + '\'' +
                ", expireTime=" + expireTime +
                ", strExpireTime='" + strExpireTime + '\'' +
                ", totalConsume=" + totalConsume +
                ", memberCardRemain=" + memberCardRemain +
                ", level=" + level +
                ", strLevel='" + strLevel + '\'' +
                ", memberScore=" + memberScore +
                '}';
    }
}
