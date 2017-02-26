package com.kylin.vo.myenum;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
public enum RoomType {
    SingleRoom("单人间"),
    StandardRoom("标准间"),
    Suite("套房");

    private String type;

    RoomType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static RoomType getEnum(String input) {
        for (RoomType type : RoomType.values()) {
            if (type.getType().equals(input))
                return type;
        }
        return null;
    }

    public static void main(String[] args) {
        RoomType roomType = RoomType.values()[0];
        System.out.println(roomType.getType());

        RoomType roomType2 = RoomType.values()[1];
        System.out.println(roomType2.getType());
    }
}
