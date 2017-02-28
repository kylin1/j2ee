package com.kylin.vo;

import com.kylin.tools.myenum.SystemUserType;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 *
 * 登录结果
 */
public class LoginResultVO {

    private int userID;

    // user type
    private SystemUserType userType;

    public LoginResultVO(int userID, SystemUserType userType) {
        this.userID = userID;
        this.userType = userType;
    }

    public int getUserID() {
        return userID;
    }

    public SystemUserType getUserType() {
        return userType;
    }
}
