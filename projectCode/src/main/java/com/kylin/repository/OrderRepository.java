package com.kylin.repository;

import com.kylin.model.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kylin on 18/02/2017.
 * All rights reserved.
 */
public interface OrderRepository extends JpaRepository<UserOrder,Integer> {

}
