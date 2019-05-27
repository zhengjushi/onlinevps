package com.gdss.onlinevpsystem.mapper;

import com.gdss.onlinevpsystem.entity.JsPro;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsProMapperTest {

    @Autowired
    private JsProMapper mapper;

    @Test
    public void findById() {
        JsPro jsPro = mapper.findById(1);
        System.out.println(jsPro);
    }

    @Test
    public void findAll() {
        List<JsPro> list = mapper.findAll();
        System.out.println(list.size());
    }

    @Test
    public void insertOne() {
        JsPro jsPro = new JsPro();
        jsPro.setProName("test4-name");
        jsPro.setProDesc("test4-desc");
        jsPro.setProExample("test4-example");
        Integer integer = mapper.insertOne(jsPro);
        System.out.println(integer);
    }

    @Test
    public void deleteOne() {
        Integer deleteOne = mapper.deleteOne(5);
        System.out.println(deleteOne);
    }

    @Test
    public void updateOne() {
        JsPro jsPro = new JsPro(1,"testname-1","testdesc-1","testexample-1");
        Integer updateOne = mapper.updateOne(jsPro);
        System.out.println(updateOne);
    }
}