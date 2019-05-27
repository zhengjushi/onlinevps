package com.gdss.onlinevpsystem.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;


@Data
public class Css {

    private Integer cId;

    // css属性名
    @Length(min = 1,message = "属性名不能为空")
    private String cName;

    // css属性描述
    @Length(min = 1,message = "属性描述不能为空")
    private String cDesc;

    // css属性示例
    @Length(min = 1,message = "属性示例不呢个为空")
    private String cExample;
}
