package com.kylin.repository;

import com.kylin.model.Bankcard;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kylin on 15/03/2017.
 * All rights reserved.
 */
public interface BankcardRepository extends JpaRepository<Bankcard, Integer> {

    Bankcard findByCardNumber(String cardNumber);

}
