package com.kylin.repository;

import com.kylin.model.HotelRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by kylin on 09/03/2017.
 * All rights reserved.
 */
public interface HotelRequestRepository extends JpaRepository<HotelRequest,Integer> {

    List<HotelRequest> findByStatus(int status);

    List<HotelRequest> findByHotelIdAndStatus(int hotelId,int status);

    List<HotelRequest> findByHotelIdAndStatusAndType(int hotelId,int status,int type);

    @Query("select h.name from HotelRequest h where h.id = :id")
    String findNameById(@Param(value = "id") int id);
}
