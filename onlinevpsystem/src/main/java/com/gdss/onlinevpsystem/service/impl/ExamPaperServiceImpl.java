package com.gdss.onlinevpsystem.service.impl;

import com.gdss.onlinevpsystem.entity.ExamPaper;
import com.gdss.onlinevpsystem.entity.ExamQuestion;
import com.gdss.onlinevpsystem.mapper.ExamPaperMapper;
import com.gdss.onlinevpsystem.mapper.ExamQuestionMapper;
import com.gdss.onlinevpsystem.service.ExamPaperService;
import io.swagger.annotations.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExamPaperServiceImpl implements ExamPaperService {

    @Autowired
    private ExamPaperMapper mapper;

    @Autowired
    private ExamQuestionMapper mapper2;

    @Transactional
    @Override
    public ExamPaper findOne(Integer id) {
        ExamPaper examPaper = mapper.findOne(id);
        if (examPaper == null)
            throw new RuntimeException("找不到此试卷");
        List<ExamQuestion> list = mapper2.findByEid(id);
        if (list.size() <= 0)
            throw new RuntimeException("此试卷未添加题目");
        examPaper.setList(list);
        return examPaper;
    }

    @Override
    public List<ExamPaper> findAll() {
        List<ExamPaper> list = mapper.findAll();
        if (list.size() <= 0)
            throw new RuntimeException("无试卷");
        for (int i=0; i<list.size(); i++){
            ExamPaper examPaper = list.get(i);
            List<ExamQuestion> byEid = mapper2.findByEid(examPaper.getEId());
            examPaper.setList(byEid);
            list.set(i,examPaper);
        }
        return list;
    }

    @Transactional
    @Override
    public Integer insertOne(ExamPaper examPaper) {
        ExamPaper examPaper1 = mapper.findByTitle(examPaper.getETitle());
        if (examPaper1 != null)
            throw new RuntimeException("该试卷已存在");
        Integer result = mapper.insertOne(examPaper);
        if (result <= 0)
            throw new RuntimeException("添加失败，请重试");
        return result;
    }

    @Transactional
    @Override
    public Integer deleteOne(Integer id) {
        ExamPaper paper = mapper.findOne(id);
        if (paper == null)
            throw new RuntimeException("此试卷不存在");

        // 先删除本张试卷的所有题目，再删除试卷
        Integer result2 = mapper2.deleteByEid(id);
        Integer result = mapper.deleteOne(id);
        if (result <= 0)
            throw new RuntimeException("删除失败请重试");
        return result;
    }

    @Transactional
    @Override
    public Integer updateOne(ExamPaper examPaper) {
        ExamPaper paper = mapper.findOne(examPaper.getEId());
        if (paper == null)
            throw new RuntimeException("此试卷不存在");
        Integer result = mapper.updateOne(examPaper);
        if (result <= 0)
            throw new RuntimeException("更新失败请重试");
        return result;
    }
}
