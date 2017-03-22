package com.kylin.repository;

import com.kylin.model.Approval;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kylin on 17/02/2017.
 * All rights reserved.
 */
public interface ApprovalRepository extends JpaRepository<Approval,Integer> {

}
