package com.kylin.vo;

import com.kylin.vo.myenum.UserType;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
public class LoginResultVO {

    // user type
    private UserType userType;

    // whether user log in success
    private boolean isPass;

    // user not exists / password not corrent etc.
    private String message;

    public LoginResultVO(UserType userType, boolean isPass, String message) {
        this.userType = userType;
        this.isPass = isPass;
        this.message = message;
    }

    public UserType getUserType() {
        return userType;
    }

    public boolean isPass() {
        return isPass;
    }

    public String getMessage() {
        return message;
    }
}
