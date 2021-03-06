package com.kylin.service;

import com.kylin.vo.MyMessage;

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
    MyMessage login(String account, String password);

    /**
     * 注册
     *
     * @param account
     * @param password
     * @return
     */
    MyMessage signUp(String account, String password);

}
