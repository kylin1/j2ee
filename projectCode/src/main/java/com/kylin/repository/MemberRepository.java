package com.kylin.repository;

import com.kylin.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kylin on 18/02/2017.
 * All rights reserved.
 */
public interface MemberRepository extends JpaRepository<Member,Integer> {

    Member findByUserId(int userId);

    Member findByName(String name);
}
