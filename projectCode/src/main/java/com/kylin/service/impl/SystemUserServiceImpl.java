package com.kylin.service.impl;

import com.kylin.service.SystemUserService;
import com.kylin.vo.common.MyMessage;
import org.springframework.stereotype.Service;

/**
 * Created by kylin on 22/02/2017.
 * All rights reserved.
 */
@Service
public class SystemUserServiceImpl implements SystemUserService {
    @Override
    public MyMessage login(String account, String password) {
        return null;
    }

    @Override
    public MyMessage signUp(String account, String password) {
        return null;
    }
}
