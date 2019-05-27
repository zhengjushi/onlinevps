package com.gdss.onlinevpsystem.service;

import com.gdss.onlinevpsystem.entity.Html;

import java.util.List;

public interface HtmlService {

    Html findById(Integer id);

    List<Html> findAll();

    Integer insertOne(Html html);

    Integer deleteOne(Integer id);

    Integer updateOne(Html html);

}
