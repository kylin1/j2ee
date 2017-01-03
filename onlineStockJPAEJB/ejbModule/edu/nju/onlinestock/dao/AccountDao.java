package edu.nju.onlinestock.dao;

import edu.nju.onlinestock.dao.exception.BalanceException;
import edu.nju.onlinestock.model.Account;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by kylin on 03/01/2017.
 * All rights reserved.
 */
@Remote
public interface AccountDao {
    public Account getAccountByAccountid(String accountid);
    @SuppressWarnings("unchecked")
    public List getAccountByCustomName(String customName);
    public double getTotalBankValue();
    public void debit(Account account, double amount) throws BalanceException;
    public void credit(Account account, double amount);
    public boolean insertAccount(String accountid, String name, double balance);
}

