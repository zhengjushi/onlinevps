package com.gdss.onlinevpsystem.mapper;

import com.gdss.onlinevpsystem.entity.JsObj;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsObjMapperTest {

    @Autowired
    private JsObjMapper mapper;

    @Test
    public void findById() {
        JsObj jsObj = mapper.findById(1);
        System.out.println(jsObj);
    }

    @Test
    public void findAll() {
        List<JsObj> list = mapper.findAll();
        System.out.println(list);
    }

    @Test
    public void insertOne() {
        JsObj jsObj = new JsObj();
        jsObj.setObjName("test2-name");
        jsObj.setObjDesc("test2-desc");
        jsObj.setObjExample("test2-example");
        Integer insertOne = mapper.insertOne(jsObj);
        System.out.println(insertOne);
    }

    @Test
    public void deleteOne() {
        Integer deleteOne = mapper.deleteOne(1);
        System.out.println(deleteOne);
    }

    @Test
    public void updateOne() {
        JsObj jsObj = new JsObj(1,"testname-1","testdesc-1","testexample-1");
        Integer updateOne = mapper.updateOne(jsObj);
        System.out.println(updateOne);
    }
}