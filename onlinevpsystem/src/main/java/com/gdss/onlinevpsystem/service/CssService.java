package com.gdss.onlinevpsystem.service;

import com.gdss.onlinevpsystem.entity.Css;

import java.util.List;

public interface CssService {

    Css findById(Integer id);

    List<Css> findAll();

    Integer insertOne(Css css);

    Integer deleteOne(Integer id);

    Integer updateOne(Css css);
}
