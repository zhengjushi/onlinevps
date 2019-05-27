package com.gdss.onlinevpsystem.service.impl;

import com.gdss.onlinevpsystem.entity.ExamQuestion;
import com.gdss.onlinevpsystem.mapper.ExamQuestionMapper;
import com.gdss.onlinevpsystem.service.ExamQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExamQuestionServiceImpl implements ExamQuestionService {

    @Autowired
    private ExamQuestionMapper mapper;

    @Override
    public List<ExamQuestion> findByEid(Integer id) {
        List<ExamQuestion> list = mapper.findByEid(id);
        if (list.size() <= 0)
            throw new RuntimeException("此试卷没有题目，请添加");
        return list;
    }

    @Override
    public ExamQuestion findById(Integer id) {
        ExamQuestion examQuestion = mapper.findById(id);
        return examQuestion;
    }

    @Override
    public List<ExamQuestion> findAll() {
        List<ExamQuestion> list = mapper.findAll();
        if (list.size() <= 0)
            throw new RuntimeException("没有题目，请添加");
        return list;
    }

    @Transactional
    @Override
    public Integer insertOne(ExamQuestion examQuestion) {
        ExamQuestion examQuestion1 = mapper.findByQquestion(examQuestion.getQQuestion());
        if (examQuestion1 != null)
            throw new RuntimeException("此题目已存在");
        Integer result = mapper.insertOne(examQuestion);
        if (result <= 0)
            throw new RuntimeException("添加失败，请重试");
        return result;
    }

    @Transactional
    @Override
    public Integer deleteOne(Integer id) {
        ExamQuestion examQuestion = mapper.findById(id);
        if (examQuestion == null)
            throw new RuntimeException("此题目不存在");
        Integer result = mapper.deleteOne(id);
        if (result <= 0)
            throw new RuntimeException("删除失败,请重试");
        return result;
    }

    @Transactional
    @Override
    public Integer deleteByEid(Integer id) {
        Integer result = mapper.deleteByEid(id);

        return result;
    }

    @Transactional
    @Override
    public Integer updateById(ExamQuestion examQuestion) {
        ExamQuestion examQuestion1 = mapper.findById(examQuestion.getQId());
        if (examQuestion1 == null)
            throw new RuntimeException("没有此题目");
        Integer result = mapper.updateById(examQuestion);
        if (result <= 0)
            throw new RuntimeException("更新失败，请重试");
        return result;
    }
}
