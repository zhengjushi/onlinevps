package com.gdss.onlinevpsystem.controller;

import com.gdss.onlinevpsystem.vo.ResultUtil;
import com.gdss.onlinevpsystem.vo.ResultVO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.validation.BindException;

@ControllerAdvice
public class MyControllerAdvice {

    /**
     *  全局异常处理
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultVO errorHandler(Exception e){
        if ( e instanceof BindException){
            BindException exception = (BindException) e;
            return ResultUtil.error(exception.getAllErrors().get(0).getDefaultMessage(),100);
        }else {
            return ResultUtil.error(e.getMessage(), -1);
        }
    }
}
