package com.kylin.repository;


import com.kylin.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kylin on 17/02/2017.
 * All rights reserved.
 */
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

}
