package com.kylin.service.impl;

import com.kylin.model.SystemUser;
import com.kylin.repository.SystemUserRepository;
import com.kylin.service.SystemUserService;
import com.kylin.tools.myenum.SystemUserType;
import com.kylin.vo.LoginResultVO;
import com.kylin.vo.common.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    protected SystemUserRepository repository;

    @Override
    public LoginResultVO login(String account, String password)  {
        //根据邮箱信息查询用户
        SystemUser user = repository.findByAccount(account);
        //查询不到用户
        if(user == null){
            return new LoginResultVO(false,"用户不存在");
        }

        // 查询到了用户,下面检查类型
        int intType = user.getType();
        SystemUserType systemUserType = SystemUserType.getType(intType);

        //密码正确
        if (user.getPassword().equals(password)) {
            return new LoginResultVO(true, user.getId(), systemUserType);

        //密码错误
        } else {
            return new LoginResultVO(false,"密码错误");
        }
    }

    @Override
    public MyMessage signUp(String account, String password, SystemUserType userType) {
        SystemUser user = repository.findByAccount(account);
        //查询不到用户
        if (user == null) {
            SystemUser systemUser = new SystemUser();
            systemUser.setAccount(account);
            systemUser.setPassword(password);
            systemUser.setType(userType.getType());
            this.repository.save(systemUser);

            int id = systemUser.getId();
            MyMessage myMessage = new MyMessage(true);
            myMessage.setData(id);

            return myMessage;
        } else
            return new MyMessage(false, "账户已经存在");
    }
}
