package com.kylin.vo;

import com.kylin.tools.myenum.SystemUserType;
import com.kylin.vo.common.MyMessage;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 *
 * 登录结果
 */
public class LoginResultVO extends MyMessage{

    private int userID;

    // user type
    private SystemUserType userType;

    public LoginResultVO(boolean isSuccess, String displayMessage) {
        super(isSuccess, displayMessage);
    }

    public LoginResultVO(boolean isSuccess,int userID, SystemUserType userType) {
        super(isSuccess);
        this.userID = userID;
        this.userType = userType;
    }

    public int getUserID() {
        return userID;
    }

    public SystemUserType getUserType() {
        return userType;
    }

    @Override
    public String toString() {
        return "LoginResultVO{" +
                "userID=" + userID +
                ", userType=" + userType +
                '}';
    }
}
