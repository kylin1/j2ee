package com.kylin.service;

import com.kylin.tools.myexception.BadInputException;
import com.kylin.tools.myexception.NotFoundException;
import com.kylin.vo.LoginResultVO;
import com.kylin.vo.common.MyMessage;
import com.kylin.tools.myenum.SystemUserType;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 */
public interface SystemUserService {

    /**
     * 登录
     *
     * @param account
     * @param password
     * @return
     */
    LoginResultVO login(String account, String password) throws NotFoundException, BadInputException;

    /**
     * 注册
     *
     * @param account
     * @param password
     * @return
     */
    MyMessage signUp(String account, String password, SystemUserType userType);

}
