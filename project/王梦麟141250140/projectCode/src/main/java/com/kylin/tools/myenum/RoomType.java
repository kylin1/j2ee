package com.kylin.tools.myenum;

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

    public static RoomType getEnum(int input) {
        return  RoomType.values()[input];
    }

    public static void main(String[] args) {
        RoomType roomType = RoomType.StandardRoom;
        System.out.println(roomType.getPeople());
    }

    public int getPeople() {
        if(this.getType().equals(RoomType.SingleRoom.getType()))
            return 1;
        else if(this.getType().equals(RoomType.StandardRoom.getType()))
            return 2;
        else if(this.getType().equals(RoomType.Suite.getType()))
            return 2;
        return 0;
    }
}
