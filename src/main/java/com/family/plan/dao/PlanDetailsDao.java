package com.family.plan.dao;

import com.family.plan.model.PlanDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanDetailsDao extends JpaRepository<PlanDetails, Long> {
    List<PlanDetails> findAllByPlanId(Long planId);
}
