package com.gdss.onlinevpsystem.entity;

import lombok.Data;

/**
 * js 的对象实体类
 */
@Data
public class JsObj {

    private Integer objId;

    private String objName;

    private String objDesc;

    private String objExample;

    public JsObj() {
    }

    public JsObj(Integer objId, String objName, String objDesc, String objExample) {
        this.objId = objId;
        this.objName = objName;
        this.objDesc = objDesc;
        this.objExample = objExample;
    }

    public JsObj(String objName, String objDesc, String objExample) {
        this.objName = objName;
        this.objDesc = objDesc;
        this.objExample = objExample;
    }
}
