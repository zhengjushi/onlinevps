package com.gdss.onlinevpsystem.service;

import com.gdss.onlinevpsystem.entity.Css;

import java.util.List;

public interface CssService {

    Css save(Css css);

    List<Css> findAll();

    void delete(Integer cId);

    Css findById(Integer cId);
}
