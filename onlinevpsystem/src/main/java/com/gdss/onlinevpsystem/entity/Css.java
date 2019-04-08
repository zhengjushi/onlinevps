package com.gdss.onlinevpsystem.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DynamicUpdate
@Data
public class Css {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cId;

    // css属性名
    private String cName;

    // css属性描述
    private String cDesc;

    // css属性示例
    private String cExample;
}
