package com.gdss.onlinevpsystem.service.impl;

import com.gdss.onlinevpsystem.mapper.ExamPaperMapper;
import com.gdss.onlinevpsystem.service.ExamPaperService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExamPaperServiceImplTest {

    @Autowired
    private ExamPaperService service;

    @Test
    public void findOne() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void insertOne() {
    }

    @Test
    public void deleteOne() {
        Integer integer = service.deleteOne(6);
        System.out.println(integer);
    }

    @Test
    public void updateOne() {
    }
}