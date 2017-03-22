package com.kylin.repository;

import com.kylin.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kylin on 18/02/2017.
 * All rights reserved.
 */
public interface ManagerRepository extends JpaRepository<SystemUser,Integer> {
}
