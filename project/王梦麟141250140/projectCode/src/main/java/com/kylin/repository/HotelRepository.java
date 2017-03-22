package com.kylin.repository;


import com.kylin.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by kylin on 17/02/2017.
 * All rights reserved.
 */
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    List<Hotel> findByLocationIgnoreCaseContaining(String address);

    Hotel findByUserId(int userId);

    @Query("select h.name from Hotel h where h.id = :id")
    String findNameById(@Param("id")int id);

    @Query("select h.id from Hotel h where h.userId = :userId")
    Integer findIdByUserId(@Param("userId")int userId);

}
