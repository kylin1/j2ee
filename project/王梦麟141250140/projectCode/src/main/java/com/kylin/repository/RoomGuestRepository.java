package com.kylin.repository;

import com.kylin.model.RoomGuest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by kylin on 18/02/2017.
 * All rights reserved.
 */
public interface RoomGuestRepository extends JpaRepository<RoomGuest, Integer> {

    @Query("select h.name from RoomGuest h where h.orderId = :orderId")
    List<String> findNameByOrderId(@Param("orderId") int orderId);

    @Query("select h from RoomGuest h where h.roomId = :roomId" +
            " and h.date = :oneDay ")
    List<RoomGuest> findByRoomIdAndDate(@Param("roomId")int roomId,
                                        @Param("oneDay")Date oneDay);
}
