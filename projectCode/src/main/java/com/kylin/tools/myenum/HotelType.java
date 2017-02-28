package com.kylin.tools.myenum;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
public enum HotelType {

    ChainHotel("快捷连锁酒店"),
    OneStar("一星级酒店"),
    TwoStar("二星级酒店"),
    ThreeStar("三星级酒店"),
    FourStar("四星级酒店"),
    FiveStar("五星级酒店");

    private String type;

    HotelType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static HotelType getEnum(String input) {
        for (HotelType type : HotelType.values()) {
            if (type.getType().equals(input))
                return type;
        }
        return null;
    }

    public static HotelType getEnum(int input) {
        return HotelType.values()[input];
    }
}
