package com.gdss.onlinevpsystem.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;


@Data
public class Html {

    private Integer hId;

    // 标签名
    @Length(min = 1,message = "‘标签名’不能为空")
    private String hName;

    // 标签描述
    @Length(min = 1,message = "‘标签描述’不能为空")
    private String hDesc;

    // 标签示例
    @Length(min = 1,message = "‘示例’不能为空")
    private String hExample;

    public Html(Integer hId, @Length(min = 1, message = "‘标签名’不能为空") String hName, @Length(min = 1, message = "‘标签描述’不能为空") String hDesc, @Length(min = 1, message = "‘示例’不能为空") String hExample) {
        this.hId = hId;
        this.hName = hName;
        this.hDesc = hDesc;
        this.hExample = hExample;
    }

    public Html(@Length(min = 1, message = "‘标签名’不能为空") String hName, @Length(min = 1, message = "‘标签描述’不能为空") String hDesc, @Length(min = 1, message = "‘示例’不能为空") String hExample) {
        this.hName = hName;
        this.hDesc = hDesc;
        this.hExample = hExample;
    }

    public Html() {}

}
