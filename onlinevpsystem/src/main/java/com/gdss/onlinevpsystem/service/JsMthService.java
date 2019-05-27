package com.gdss.onlinevpsystem.service;

import com.gdss.onlinevpsystem.entity.JsMth;
import java.util.List;

public interface JsMthService {

    JsMth findById(Integer id);

    List<JsMth> findAll();

    Integer insertOne(JsMth jsMth);

    Integer deleteOne(Integer id);

    Integer updateOne(JsMth jsMth);
}
