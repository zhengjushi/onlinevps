package com.gdss.onlinevpsystem.mapper;

import com.gdss.onlinevpsystem.entity.ExamQuestion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExamQuestionMapperTest {

    @Autowired
    private ExamQuestionMapper mapper;

    @Test
    public void findByEid() {
        List<ExamQuestion> list = mapper.findByEid(1);
        System.out.println(list.size());
    }

    @Test
    public void insertOne(){
        ExamQuestion examQuestion = new ExamQuestion();
        examQuestion.setQAnswer("testQAnswer");
        examQuestion.setQQuestion("testQQuestion");
        examQuestion.setQA("testA");
        examQuestion.setQB("testB");
        examQuestion.setQC("testC");
        examQuestion.setQD("testD");
        examQuestion.setEId(6);
        mapper.insertOne(examQuestion);
    }

    @Test
    public void deleteOne(){
        Integer deleteOne = mapper.deleteOne(24);
        System.out.println(deleteOne);
    }

    @Test
    public void deleteByEid(){
        Integer deleteByEid = mapper.deleteByEid(2);
        System.out.println(deleteByEid);
    }

    @Test
    public void updateById(){
        ExamQuestion examQuestion = new ExamQuestion();
        examQuestion.setQId(23);
        examQuestion.setQAnswer("testQAnswer");
        examQuestion.setQQuestion("testQQuestion");
        examQuestion.setQA("testA");
        examQuestion.setQB("testB");
        examQuestion.setQC("testC");
        examQuestion.setQD("testD");

        Integer integer = mapper.updateById(examQuestion);
        System.out.println(integer);
    }

}