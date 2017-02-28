package com.kylin.service.impl;

import com.kylin.model.SystemUser;
import com.kylin.repository.SystemUserRepository;
import com.kylin.service.SystemUserService;
import com.kylin.tools.myexception.BadInputException;
import com.kylin.tools.myexception.NotFoundException;
import com.kylin.vo.LoginResultVO;
import com.kylin.vo.common.MyMessage;
import com.kylin.tools.myenum.SystemUserType;
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
    public LoginResultVO login(String account, String password) throws NotFoundException, BadInputException {
        //根据邮箱信息查询用户
        SystemUser user = repository.findByAccount(account);
        //查询不到用户
        if (user == null) {
            throw new NotFoundException("用户不存在");
        }
        //密码正确
        if (user.getPassword().equals(password)) {
            int intType = user.getType();
            SystemUserType systemUserType = SystemUserType.getType(intType);
            return new LoginResultVO(user.getId(), systemUserType);
        } else {
            throw new BadInputException("密码错误");
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
            return new MyMessage(true);
        } else
            return new MyMessage(false, "账户已经存在");
    }
}
