package com.gdss.onlinevpsystem.vo;

import com.gdss.onlinevpsystem.enums.Status;
import lombok.Data;

@Data
public class ResultVO {

    private Integer code = Status.UNSUCCESS.getCode();

    private String msg = "失败";

    private Object data = null;

}
