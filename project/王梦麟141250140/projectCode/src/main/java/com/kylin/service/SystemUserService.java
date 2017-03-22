package com.kylin.service;

import com.kylin.tools.myenum.SystemUserType;
import com.kylin.vo.LoginResultVO;
import com.kylin.vo.common.MyMessage;

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
    LoginResultVO login(String account, String password);

    /**
     * 注册
     *
     * @param account
     * @param password
     * @return
     */
    MyMessage signUp(String account, String password, SystemUserType userType);

}
