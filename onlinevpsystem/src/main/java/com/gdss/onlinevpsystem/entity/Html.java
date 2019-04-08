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
public class Html {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer hId;

    // 标签名
    private String hName;

    // 标签描述
    private String hDesc;

    // 标签示例
    private String hExample;


}
