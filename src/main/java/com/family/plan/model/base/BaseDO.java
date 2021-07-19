package com.family.plan.model.base;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public class BaseDO implements Serializable {

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


}
