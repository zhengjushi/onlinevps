package com.gdss.onlinevpsystem.service;

import com.gdss.onlinevpsystem.entity.ExamPaper;

import java.util.List;

public interface ExamPaperService {

    ExamPaper findOne(Integer id);

    List<ExamPaper> findAll();

    Integer insertOne(ExamPaper examPaper);

    Integer deleteOne(Integer id);

    Integer updateOne(ExamPaper examPaper);

}
