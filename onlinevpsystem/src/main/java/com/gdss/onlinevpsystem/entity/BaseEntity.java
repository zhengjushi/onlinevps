package com.gdss.onlinevpsystem.entity;

import lombok.Data;

@Data
public class BaseEntity {

    private Integer id;

    private String name;

    private String desc;

    private String example;

    public BaseEntity(Integer id, String name, String desc, String example) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.example = example;
    }

    public BaseEntity() {
    }
}
