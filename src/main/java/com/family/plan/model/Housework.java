package com.family.plan.model;


import com.family.plan.model.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "HOUSEWORK")
@Data
public class Housework extends BaseDO {
    String hName;
}
