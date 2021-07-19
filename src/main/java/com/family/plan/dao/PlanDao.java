package com.family.plan.dao;


import com.family.plan.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlanDao extends JpaRepository<Plan, Long> {

    @Query(nativeQuery = true,
            value = "select * from plan order by distribute_time desc limit 1")
    Plan findTop1();
}
