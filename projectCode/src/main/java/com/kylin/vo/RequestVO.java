package com.kylin.vo;

import com.kylin.tools.DateHelper;
import com.kylin.tools.myenum.RequestStatus;
import com.kylin.tools.myenum.RequestType;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 */
public class RequestVO {

    // 请求的ID
    private int id;

    //hotel
    private int hotelId;

    private String hotelName;

    private String mainContent;

    // type and content
    private RequestType type;
    private String strType;

    private String detailContent;

    // status
    private RequestStatus status;
    private String strStatus;

    private Date createdTime;
    private String strTime;

    public RequestVO(int id, int hotelId, String hotelName, String mainContent,
                     RequestType type, String detailContent,RequestStatus status) {
        this.id = id;
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.mainContent = mainContent;
        this.type = type;
        this.detailContent = detailContent;
        this.status = status;
        this.init();
    }

    private void init() {

        //提交时间为当前时间
        this.createdTime = new Date();
        try {
            this.strTime = DateHelper.getDateTimeString(createdTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.strStatus = this.status.getType();
        this.strType = this.type.getStringType();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getHotelId() {
        return hotelId;
    }

    public String getMainContent() {
        return mainContent;
    }

    public RequestType getType() {
        return type;
    }

    public String getDetailContent() {
        return detailContent;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public String getStrTime() {
        return strTime;
    }

    public String getStrType() {
        return strType;
    }

    public String getStrStatus() {
        return strStatus;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "RequestVO{" +
                "id=" + id +
                ", hotelId=" + hotelId +
                ", hotelName='" + hotelName + '\'' +
                ", mainContent='" + mainContent + '\'' +
                ", type=" + type +
                ", strType='" + strType + '\'' +
                ", detailContent='" + detailContent + '\'' +
                ", status=" + status +
                ", strStatus='" + strStatus + '\'' +
                ", createdTime=" + createdTime +
                ", strTime='" + strTime + '\'' +
                '}';
    }
}
