package edu.nju.onlinestock.dao;

/**
 * Created by kylin on 03/01/2017.
 * All rights reserved.
 */

import edu.nju.onlinestock.dao.exception.BalanceException;
import edu.nju.onlinestock.model.Account;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class AccountDaoBean implements AccountDao {

    @PersistenceContext
    protected EntityManager em;

    private List list = null;

    public List getAccountByCustomName(String name) {
        try {
            Query query = em.createQuery("from Account a where a.name=name");
            list = query.getResultList();
            em.clear();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Account getAccountByAccountid(String accountid) {
        Account account = em.find(Account.class, accountid);
        return account;
    }


    public double getTotalBankValue() {
        try {
            Query query = em.createQuery("select sum(a.balance) from Account a");
            Double total = (Double) query.getSingleResult();
            em.clear();
            return total;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void credit(Account account, double amount) {
        double balance = account.getBalance();
        balance += amount;
        account.setBalance(balance);
        em.merge(account);
    }

    public void debit(Account account, double amount) throws BalanceException {
        double balance = account.getBalance();
        if (balance < amount)
            throw new BalanceException();
        balance -= amount;
        account.setBalance(balance);
        em.merge(account);
    }


    public boolean insertAccount(String accountid, String name, double balance) {
        try {
            Account account = new Account();
            account.setAccountid(accountid);
            account.setName(name);
            account.setBalance(balance);
            em.persist(account);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
