package com.kylin.repository;

import com.kylin.model.HotelRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by kylin on 18/02/2017.
 * All rights reserved.
 */
public interface HotelRoomRepository extends JpaRepository<HotelRoom,Integer> {

    List<HotelRoom> findByHotelId(int hotelId);
}
