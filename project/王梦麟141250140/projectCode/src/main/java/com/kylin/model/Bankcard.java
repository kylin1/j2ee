package com.kylin.model;

import javax.persistence.*;

/**
 * Created by kylin on 15/03/2017.
 * All rights reserved.
 */
@Entity
@Table(name = "bankcard")
public class Bankcard {

    private int id;

    private String cardNumber;

    private double balance;

    @Id
    @Column(name = "id")
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "cardNumber")
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardBumber) {
        this.cardNumber = cardBumber;
    }

    @Column(name = "balance")
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
