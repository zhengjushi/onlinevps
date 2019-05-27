package com.gdss.onlinevpsystem.mapper;

import com.gdss.onlinevpsystem.entity.Html;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HtmlMapperTest {

    @Autowired
    private HtmlMapper mapper;


    @Test
    public void findById() {
        Html h = mapper.findById(16);
        System.out.println(h);
    }

    @Test
    public void findAll(){
        List<Html> list = mapper.findAll();
        System.out.println(list.size());
    }

    @Test
    public void insertOne(){
        Html h = new Html();
        h.setHName("test");
        h.setHDesc("test");
        h.setHExample("test");
        Integer one = mapper.insertOne(h);
        System.out.println(one);
    }

    @Test
    public void deleteOne(){
        Integer one = mapper.deleteOne(29);
        System.out.println(one);
    }

    @Test
    public void updateOne(){
        Html h = new Html();
        h.setHId(28);
        h.setHName("test");
        h.setHDesc("test");
        h.setHExample("test");
        Integer updateOne = mapper.updateOne(h);
        System.out.println(updateOne);
    }
}