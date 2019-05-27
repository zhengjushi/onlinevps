package com.gdss.onlinevpsystem.mapper;

import com.gdss.onlinevpsystem.entity.ExamPaper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExamPaperMapperTest {

    @Autowired
    private ExamPaperMapper mapper;

    @Test
    public void findOne(){
        ExamPaper examPaper = mapper.findOne(1);
        System.out.println(examPaper);
    }

    @Test
    public void findAll(){
        List<ExamPaper> list = mapper.findAll();
        System.out.println(list.size());
    }

    @Test
    public void insertOne() {
        ExamPaper examPaper = new ExamPaper();
        examPaper.setEId(2);
        examPaper.setETitle("期中考试");
        Integer integer = mapper.insertOne(examPaper);
        System.out.println(integer);
    }

    @Test
    public void deleteOne(){
        Integer deleteOne = mapper.deleteOne(4);
        System.out.println(deleteOne);
    }

    @Test
    public void updateOne(){
        ExamPaper examPaper = new ExamPaper();
        examPaper.setEId(5);
        examPaper.setETitle("期末考试");
        Integer updateOne = mapper.updateOne(examPaper);
        System.out.println(updateOne);
    }
}