package com.kylin.vo.common;

/**
 * Created by kylin on 20/02/2017.
 * All rights reserved.
 *
 * service and dao message
 * indicate service success status and debug info
 *
 */
public class MyMessage {

    // service status
    private boolean isSuccess;

    // message for user to see
    private String displayMessage;

    // message for developer
    private String errorStack;

    // 数据
    private Object data;

    public MyMessage(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public MyMessage(boolean isSuccess, String displayMessage) {
        this.isSuccess = isSuccess;
        this.displayMessage = displayMessage;
    }

    public MyMessage(boolean isSuccess, String displayMessage, String errorStack) {
        this.isSuccess = isSuccess;
        this.displayMessage = displayMessage;
        this.errorStack = errorStack;
    }

    public MyMessage(boolean isSuccess, int newId) {
        this.isSuccess = isSuccess;
        this.data = newId;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    public String getErrorStack() {
        return errorStack;
    }

    public void setErrorStack(String errorStack) {
        this.errorStack = errorStack;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        if(this.isSuccess){
            return "success";
        }else {
            return "failed: "+this.displayMessage+"\n";
        }
    }
}
