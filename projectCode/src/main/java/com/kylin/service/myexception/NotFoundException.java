package com.kylin.service.myexception;

/**
 * Created by kylin on 28/02/2017.
 * All rights reserved.
 */
public class NotFoundException extends MyException{

    public NotFoundException(String errorCode) {
        super(errorCode);
    }
}
