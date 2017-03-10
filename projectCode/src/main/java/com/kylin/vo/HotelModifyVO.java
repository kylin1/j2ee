package com.kylin.vo;

import com.kylin.tools.myenum.HotelLevel;

/**
 * Created by kylin on 10/03/2017.
 * All rights reserved.
 */
public class HotelModifyVO extends HotelOpenVO{

    private String phone;

    private String legalRepresentative;

    public HotelModifyVO(int hotelId, String name, String location, HotelLevel type,
                         String phone, String legalRepresentative) {
        super(hotelId, name, location, type);
        this.phone = phone;
        this.legalRepresentative = legalRepresentative;
    }

    public String getPhone() {
        return phone;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }
}
