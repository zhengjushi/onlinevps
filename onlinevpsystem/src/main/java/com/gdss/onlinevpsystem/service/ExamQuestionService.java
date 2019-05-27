package com.gdss.onlinevpsystem.service;

import com.gdss.onlinevpsystem.entity.ExamQuestion;

import java.util.List;

public interface ExamQuestionService {

    List<ExamQuestion> findByEid(Integer id);

    ExamQuestion findById(Integer id);

    List<ExamQuestion> findAll();

    Integer insertOne(ExamQuestion examQuestion);

    Integer deleteOne(Integer id);

    Integer deleteByEid(Integer id);

    Integer updateById(ExamQuestion examQuestion);
}
