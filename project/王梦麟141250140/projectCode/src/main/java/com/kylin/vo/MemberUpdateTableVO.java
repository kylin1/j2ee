package com.kylin.vo;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 *
 * 会员个人信息修改提交表格
 */
public class MemberUpdateTableVO {

    private int memberId;

    private String name;

    private String phone;

    private String email;

    private String bankCard;

    public MemberUpdateTableVO() {
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public MemberUpdateTableVO(int memberId, String name, String phone, String email, String bankCard) {
        this.memberId = memberId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.bankCard = bankCard;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getBankCard() {
        return bankCard;
    }

    @Override
    public String toString() {
        return "MemberUpdateTableVO{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", bankCard='" + bankCard + '\'' +
                '}';
    }
}
