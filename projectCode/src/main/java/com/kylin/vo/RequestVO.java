package com.kylin.vo;

import com.kylin.tools.myenum.RequestStatus;
import com.kylin.tools.myenum.RequestType;

import java.util.Date;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 */
public class RequestVO {

    //hotel
    private int hotelId;

    private String hotelName;

    private String mainContent;

    // type and content
    private RequestType type;

    private String detailContent;

    // status
    private RequestStatus status;

    private Date createdTime;

    public RequestVO(int hotelId, String hotelName, String mainContent, RequestType type, String detailContent) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.mainContent = mainContent;
        this.type = type;
        this.detailContent = detailContent;

        //新建申请的状态是等待审批
        this.status = RequestStatus.Waiting;
        //提交时间为当前时间
        this.createdTime = new Date();
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

    @Override
    public String toString() {
        return hotelName+mainContent;
    }
}
