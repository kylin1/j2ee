package com.kylin.repository;

import com.kylin.model.HotelRoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Date;

/**
 * Created by kylin on 26/02/2017.
 * All rights reserved.
 */
public interface HotelRoomStatusRepository extends JpaRepository<HotelRoomStatus, Integer> {

    @Query("select h from HotelRoomStatus h where h.hotelRoomId = :hotelRoomId order by h.date desc")
    List<HotelRoomStatus> findByHotelRoomIdOrderByDateDesc(@Param("hotelRoomId") int hotelRoomId);

    //包含末尾哪一天的查询,4.1-4,3 返回 4.1 4.2 4.3 3天
    @Query("select h from HotelRoomStatus h where h.hotelRoomId = :hotelRoomId " +
            "and h.date between :startDate and :endDate and h.status= :status")
    List<HotelRoomStatus> findByRoomAndDateAndStatus(@Param("hotelRoomId") int hotelRoomId,
                                                     @Param("startDate") Date startDate,
                                                     @Param("endDate") Date endDate,
                                                     @Param("status") int status);

    @Query("select h from HotelRoomStatus h where h.hotelRoomId = :hotelRoomId " +
            "and h.date between :startDate and :endDate")
    List<HotelRoomStatus> findByRoomAndDate(@Param("hotelRoomId") int hotelRoomId,
                                                     @Param("startDate") Date startDate,
                                                     @Param("endDate") Date endDate);

    @Query("select h from HotelRoomStatus h where h.hotelRoomId = :roomId" +
            " and h.date = :date ")
    HotelRoomStatus findByRoomAndDate(@Param("roomId")int roomId,
                                      @Param("date")Date date);

    @Query("select h.price from HotelRoomStatus h where h.hotelRoomId = :hotelRoomId" +
            " and h.date = :date ")
    int getPriceByRoomIdAndDate(@Param("hotelRoomId") int hotelRoomId,
                                @Param("date") Date date);



}
