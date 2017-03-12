package com.kylin.repository;

import com.kylin.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by kylin on 18/02/2017.
 * All rights reserved.
 */
public interface MemberRepository extends JpaRepository<Member,Integer> {

    @Query("select h.id from Member h where h.userId = :userId")
    Integer findMemberIdByUserId(@Param("userId")int userId);

    Member findByUserId(int userId);

    Member findByName(String name);
}
