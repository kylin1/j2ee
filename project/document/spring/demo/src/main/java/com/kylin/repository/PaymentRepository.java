package com.kylin.repository;

import com.kylin.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kylin on 18/02/2017.
 * All rights reserved.
 */
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
