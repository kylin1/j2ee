package com.kylin.repository;

import com.kylin.model.Expenditure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by kylin on 18/02/2017.
 * All rights reserved.
 */
public interface ExpenditureRepository extends JpaRepository<Expenditure, Integer> {

    @Query("select h from Expenditure h where " +
            " h.date between :start and :endDate order by h.date asc")
    List<Expenditure> findByDate(@Param("start") Date start,
                                 @Param("endDate") Date endDate);
}
