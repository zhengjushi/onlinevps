package com.gdss.onlinevpsystem.service.impl;

import com.gdss.onlinevpsystem.service.CssService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CssServiceImplTest {
    @Autowired
    private CssService service;

    @Test
    public void findById() {
        service.findById(2);
    }

    @Test
    public void findAll() {
    }

    @Test
    public void insertOne() {
    }

    @Test
    public void deleteOne() {
    }

    @Test
    public void updateOne() {
    }
}