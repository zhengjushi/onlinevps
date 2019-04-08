package com.gdss.onlinevpsystem.repository;

import com.gdss.onlinevpsystem.entity.Html;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HtmlRepositoryTest {

    @Autowired
    private HtmlRepository repository;

    @Test
    public void saveTest(){
        Html html = new Html();
        html.setHName("a");
        html.setHDesc("超链接");
        html.setHExample("<a href='http://www.baidu.com'>百度</a>");
        Html save = repository.save(html);
        System.out.println(save);
        Assert.assertNotNull(save);
    }

    @Test
    public void findOne(){
        Html html = repository.findById(1).orElse(null);
        System.out.println(html);
        Assert.assertNotNull(html);
    }

}