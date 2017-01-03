package edu.nju.onlinestock.dao;

import edu.nju.onlinestock.model.User;

import javax.ejb.Remote;
import java.util.Date;
import java.util.List;

@Remote
public interface UserDao {
    public boolean insertUser(long id, String userID, String password, String name,
                              Date birthday, String phone, String email, String bankID, double account);

    public String getUserNameByID(String userID);

    public boolean updateUser(User user);

    public User getUserByID(String id);

    @SuppressWarnings("unchecked")
    public List getUserList();

    void save(User user);
}
