package com.kylin.repository;

import com.kylin.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kylin on 28/02/2017.
 * All rights reserved.
 */
public interface SystemUserRepository extends JpaRepository<SystemUser, Integer> {

    SystemUser findByAccount(String account);

}
