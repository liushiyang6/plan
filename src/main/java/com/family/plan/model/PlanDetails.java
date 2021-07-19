package com.family.plan.model;

import com.family.plan.enums.PeopleEnum;
import com.family.plan.model.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 計劃詳情
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PLAN_DETAILS")
@Data
public class PlanDetails extends BaseDO {

    /**
     * 計劃ID
     */
    private Long planId;

    /**
     * 家务ID
     */
    private Long houseworkId;

    /**
     * 家務執行人
     */
    private PeopleEnum people;
}
