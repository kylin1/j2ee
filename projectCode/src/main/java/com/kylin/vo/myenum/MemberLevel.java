package com.kylin.vo.myenum;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
public enum MemberLevel {

    High("高级会员"),
    Middle("中级会员"),
    Low("低级会员"),
    None("未激活会员");

    private String stringLevel;

    MemberLevel(String stringLevel) {
        this.stringLevel = stringLevel;
    }

    public String getStringLevel() {
        return stringLevel;
    }
}
