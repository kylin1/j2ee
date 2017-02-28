package com.kylin.tools.myexception;

/**
 * Created by kylin on 27/02/2017.
 * All rights reserved.
 */

public class BadInputException extends MyException {

    public BadInputException(String errorCode) {
        super(errorCode);
    }

}
