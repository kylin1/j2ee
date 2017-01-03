package edu.nju.onlinestock.dao;

import edu.nju.onlinestock.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;


@Stateless
public class UserDaoBean implements UserDao {

    @PersistenceContext
    protected EntityManager em;

    public User getUserByID(String id) {
        User user = em.find(User.class, id);
        return user;
    }

    @Override
    public boolean insertUser(long id, String userID, String password, String name,
                              Date birthday, String phone, String email, String bankID, double account) {
        try {
            //new状态，在数据库中不存在一条与它对应的记录
            User user = new User();
            user.setId(id);
            user.setUserid(userID);
            user.setPassword(password);
            user.setName(name);
            user.setBirthday(birthday);
            user.setPhone(phone);
            user.setEmail(email);
            user.setBankid(bankID);
            user.setAccount(account);

            //managed 状态，保存Entity到数据库中
            em.persist(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    public String getUserNameByID(String id) {
        User user = em.find(User.class, id);
        return user.getName();
    }

    @Override
    public boolean updateUser(User user) {
        try {
            //容器决定flush时，数据将同步到数据库中
            em.merge(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    public List getUserList() {
        try {
            Query query = em.createQuery("from User u order by userid asc");
            List list = query.getResultList();
            em.clear();//在处理大量实体的时候，如果不把已经处理过的实体从EntityManager中分离出来，将会消耗大量的内存；此方法分离内存中受管理的实体Bean，让VM进行垃圾回收
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }


}
