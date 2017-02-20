package edu.nju.onlinestock.dao.exception;

/**
 * Created by kylin on 03/01/2017.
 * All rights reserved.
 */
public class BalanceException extends Exception {
    public BalanceException() {
    }

    public BalanceException(String msg) {
        super(msg);
    }

    public BalanceException(Exception e) {
        super(e.toString());
    }
}
