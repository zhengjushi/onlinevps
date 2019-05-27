package com.gdss.onlinevpsystem.service;


import com.gdss.onlinevpsystem.entity.JsPro;

import java.util.List;

public interface JsProService {

    JsPro findById(Integer id);

    List<JsPro> findAll();

    Integer insertOne(JsPro jsPro);

    Integer deleteOne(Integer id);

    Integer updateOne(JsPro css);
}