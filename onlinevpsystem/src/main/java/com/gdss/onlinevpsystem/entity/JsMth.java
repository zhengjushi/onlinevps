package com.gdss.onlinevpsystem.entity;

import lombok.Data;

/**
 * JS 的方法实体类
 */
@Data
public class JsMth {

    private Integer mthId;

    private String mthName;

    private String mthDesc;

    private String mthExample;

    public JsMth(Integer mthId, String mthName, String mthDesc, String mthExample) {
        this.mthId = mthId;
        this.mthName = mthName;
        this.mthDesc = mthDesc;
        this.mthExample = mthExample;
    }

    public JsMth() {
    }

    public JsMth(String mthName, String mthDesc, String mthExample) {
        this.mthName = mthName;
        this.mthDesc = mthDesc;
        this.mthExample = mthExample;
    }
}
