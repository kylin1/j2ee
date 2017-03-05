package com.kylin.repository;

import com.kylin.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by kylin on 18/02/2017.``
 * All rights reserved.
 */
public interface PaymentRepository extends JpaRepository<Payment,Integer> {

    @Query("select h from Payment h where " +
            " h.time between :start and :endDate")
    List<Payment> findByDate(@Param("start") Date start,
                             @Param("endDate") Date endDate);
}
