package com.kylin.vo;

/**
 * Created by kylin on 10/03/2017.
 * All rights reserved.
 */
public class HotelModifyVO extends HotelOpenVO{

    private String phone;

    private String legalRepresentative;

    @Override
    public String toString() {
        return "HotelModifyVO{" +
                "phone='" + phone + '\'' +
                ", legalRepresentative='" + legalRepresentative + '\'' +
                '}';
    }


    public HotelModifyVO() {
    }

    public HotelModifyVO(int hotelId, String name, String location, int level, String phone, String legalRepresentative) {
        super(hotelId, name, location, level);
        this.phone = phone;
        this.legalRepresentative = legalRepresentative;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getPhone() {
        return phone;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }
}
