package com.gdss.onlinevpsystem.service;

import com.gdss.onlinevpsystem.entity.JsObj;

import java.util.List;

public interface JsObjService {


    JsObj findById(Integer id);

    List<JsObj> findAll();

    Integer insertOne(JsObj jsObj);

    Integer deleteOne(Integer id);

    Integer updateOne(JsObj jsObj );
}
