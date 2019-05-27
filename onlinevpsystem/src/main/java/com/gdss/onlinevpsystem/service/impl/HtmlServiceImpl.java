package com.gdss.onlinevpsystem.service.impl;

import com.gdss.onlinevpsystem.entity.Html;
import com.gdss.onlinevpsystem.mapper.HtmlMapper;
import com.gdss.onlinevpsystem.service.HtmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HtmlServiceImpl implements HtmlService {

    @Autowired
    private HtmlMapper mapper;

    @Override
    public Html findById(Integer id) {
        Html html = mapper.findById(id);
        if (html == null)
            throw new RuntimeException("找不到此数据");
        return html;
    }

    @Override
    public List<Html> findAll() {
        List<Html> list = mapper.findAll();
        if (list.size() <= 0)
            throw new  RuntimeException("无数据");
        return list;
    }

    @Override
    public Integer insertOne(Html html) {
        Html html1 = mapper.findByName(html.getHName());
        if (html1 != null)
            throw new RuntimeException("已存在");
        Integer result = mapper.insertOne(html);
        if (result <= 0)
            throw new RuntimeException("添加失败，请重试");
        return result;
    }

    @Override
    public Integer deleteOne(Integer id) {
        Html html = mapper.findById(id);
        if (html == null)
            throw new RuntimeException("找不到本条数据");
        Integer result = mapper.deleteOne(id);
        if (result <= 0)
            throw new RuntimeException("删除失败,请重试");
        return result;
    }

    @Override
    public Integer updateOne(Html html) {
        Html html1 = mapper.findById(html.getHId());
        if (html1 == null)
            throw new RuntimeException("找不到本条数据");
        Integer result = mapper.updateOne(html);
        if (result <= 0)
            throw new RuntimeException("更新失败，请重试");
        return result;
    }
}
