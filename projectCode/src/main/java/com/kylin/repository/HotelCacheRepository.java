package com.kylin.repository;

import com.kylin.model.HotelCache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by kylin on 09/03/2017.
 * All rights reserved.
 */
public interface HotelCacheRepository extends JpaRepository<HotelCache,Integer> {

    List<HotelCache> findByStatus(int status);

    List<HotelCache> findByUserIdAndStatus(int userId, int status);
}
