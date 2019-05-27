package com.gdss.onlinevpsystem.enums;

import lombok.Getter;

/**
 *  状态码
 */
@Getter
public enum Status {
    SUCCESS(0),
    UNSUCCESS(1),
    ADDERROR(100),
    FINDALLERROR(101),
    DELETEERROR(102),
    FINDBYID(103)
    ;
    private Integer code;

    Status(Integer code) {
        this.code = code;
    }
}
