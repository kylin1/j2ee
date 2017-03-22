package com.kylin.tools.myenum;

/**
 * Created by kylin on 28/02/2017.
 * All rights reserved.
 */
public enum SystemUserType {

    Guest(0),

    Hotel(1),

    Manager(2);

    private Integer status;

    SystemUserType(int status) {
        this.status = status;
    }

    public Integer getType() {
        return status;
    }

    public static SystemUserType getType(int input) {
        if (input <= 2)
            return SystemUserType.values()[input];
        else
            return null;
    }

}
