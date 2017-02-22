package com.kylin.vo;

import com.kylin.vo.myenum.RequestStatus;
import com.kylin.vo.myenum.RequestType;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 */
public class RequestVO {

    private int hotelId;

    private String mainContent;

    private RequestType type;

    private String detailContent;

    private RequestStatus status;

    public RequestVO(int hotelId, String mainContent, RequestType type, String detailContent) {
        this.hotelId = hotelId;
        this.mainContent = mainContent;
        this.type = type;
        this.detailContent = detailContent;

        //新建申请的状态是等待审批
        this.status = RequestStatus.Waiting;
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
}
