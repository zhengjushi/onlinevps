package com.gdss.onlinevpsystem.vo;

import com.gdss.onlinevpsystem.enums.Status;

public class ResultUtil {

    public static ResultVO success(String msg, Object data){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(Status.SUCCESS.getCode());
        resultVO.setMsg(msg);
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO success(String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(Status.SUCCESS.getCode());
        resultVO.setMsg(msg);
        resultVO.setData(null);
        return resultVO;
    }

    public static ResultVO error(String msg, Integer code){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        resultVO.setData(null);
        return resultVO;
    }
}
