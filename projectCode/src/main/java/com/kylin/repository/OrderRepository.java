package com.kylin.repository;

import com.kylin.model.MemberOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by kylin on 18/02/2017.
 * All rights reserved.
 */
public interface OrderRepository extends JpaRepository<MemberOrder,Integer> {

    List<MemberOrder> findByMemberId(int memberId);

    List<MemberOrder> findByMemberIdAndStatus(int memberId, int status);

    List<MemberOrder> findByHotelId(int hotelId);

    List<MemberOrder> findByHotelIdAndStatus(int hotelId, int status);
}
