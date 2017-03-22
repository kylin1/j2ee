package com.kylin.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by kylin on 17/02/2017.
 * All rights reserved.
 */
@Entity
@Table(name = "member")
public class Member {

    private int id;

    private String name;
    private String phone;
    private String email;
    private int status;

    private String bankCard;
    private Date activatedTime;
    private Date expireTime;

    private int consume;
    private int balance;
    private int level;
    private int score;

    private int userId;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Column(name = "bankCard")
    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    @Column(name = "activatedTime")
    public Date getActivatedTime() {
        return activatedTime;
    }

    public void setActivatedTime(Date activatedTime) {
        this.activatedTime = activatedTime;
    }

    @Column(name = "expireTIme")
    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTIme) {
        this.expireTime = expireTIme;
    }

    @Column(name = "consume")
    public int getConsume() {
        return consume;
    }

    public void setConsume(int consume) {
        this.consume = consume;
    }

    @Column(name = "balance")
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Column(name = "level")
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Column(name = "score")
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Column(name = "userId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", bankCard='" + bankCard + '\'' +
                ", activatedTime=" + activatedTime +
                ", expireTime=" + expireTime +
                ", consume=" + consume +
                ", balance=" + balance +
                ", level=" + level +
                ", score=" + score +
                ", userId=" + userId +
                '}';
    }
}
