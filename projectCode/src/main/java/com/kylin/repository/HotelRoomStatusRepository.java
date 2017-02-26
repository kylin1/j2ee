package com.kylin.repository;

import com.kylin.model.HotelRoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by kylin on 26/02/2017.
 * All rights reserved.
 */
public interface HotelRoomStatusRepository extends JpaRepository<HotelRoomStatus, Integer> {

    @Query("select h from HotelRoomStatus h where h.hotelRoomId = :hotelRoomId order by h.date desc")
    List<HotelRoomStatus> findByHotelRoomIdOrderByDateDesc(@Param("hotelRoomId") int hotelRoomId);

    @Query("select h from HotelRoomStatus h where h.hotelRoomId = :hotelRoomId " +
            "and h.date >= :startDate and h.date <= :endDate and h.status= :status ")
    List<HotelRoomStatus> findByRoomAndDateAndStatus(@Param("hotelRoomId") int hotelRoomId,
                                                     @Param("startDate")Date startDate,
                                                     @Param("endDate")Date endDate,
                                                     @Param("status")int status);

}
