package com.kylin.tools.myenum;

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

    public static MemberLevel getEnum(String input) {
        for (MemberLevel type : MemberLevel.values()) {
            if (type.getStringLevel().equals(input))
                return type;
        }
        return null;
    }

    public static MemberLevel getEnum(int input) {
        switch(input) {
            case 0:
                return None;
            case 1:
                return Low;
            case 2:
                return Middle;
            case 3:
                return High;
        }
        return null;
    }
}
