package com.family.plan.model;

import com.family.plan.model.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PLAN")
@Data
public class Plan extends BaseDO {

    /**
     * 家務分配時間
     */
    private LocalDateTime distributeTime;

}
