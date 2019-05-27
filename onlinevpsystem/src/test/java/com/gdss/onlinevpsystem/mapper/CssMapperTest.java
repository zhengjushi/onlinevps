package com.gdss.onlinevpsystem.mapper;

import com.gdss.onlinevpsystem.entity.Css;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CssMapperTest {

    @Autowired
    private CssMapper mapper;

    @Test
    public void findById() {
        Css byId = mapper.findById(2);
        System.out.println(byId);
    }

    @Test
    public void findAll(){
        List<Css> list = mapper.findAll();
        for(Css css :list){
            System.out.println(css+"\n");
        }
        System.out.println(list.size());
    }

    @Test
    public void insertOne() {
        Css css = new Css();
        css.setCName("test");
        css.setCDesc("test");
        css.setCExample("test");
        Integer insertOne = mapper.insertOne(css);
        System.out.println(insertOne);
    }

    @Test
    public void deleteOne() {
        Integer deleteOne = mapper.deleteOne(10);
        System.out.println(deleteOne);
    }

    @Test
    public void updateOne() {
        Css css = new Css();
        css.setCId(2);
        css.setCName("test");
        css.setCDesc("test2");
        css.setCExample("test2");
        Integer updateOne = mapper.updateOne(css);
        System.out.println(updateOne);
    }
}