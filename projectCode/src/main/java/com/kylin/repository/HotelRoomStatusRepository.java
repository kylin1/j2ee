package com.kylin.repository;

import com.kylin.model.HotelRoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by kylin on 26/02/2017.
 * All rights reserved.
 */
public interface HotelRoomStatusRepository extends JpaRepository<HotelRoomStatus, Integer> {

    @Query("select h from HotelRoomStatus h where h.hotelRoomId = :hotelRoomId order by h.date desc")
    List<HotelRoomStatus> findByHotelRoomIdOrderByDateDesc(@Param("hotelRoomId") int hotelRoomId);

}
