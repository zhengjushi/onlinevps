package com.gdss.onlinevpsystem.service.impl;

import com.gdss.onlinevpsystem.entity.JsPro;
import com.gdss.onlinevpsystem.mapper.JsProMapper;
import com.gdss.onlinevpsystem.service.JsProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JsProServiceImpl implements JsProService {

    @Autowired
    private JsProMapper mapper;

    @Override
    public JsPro findById(Integer id) {
        JsPro jsPro = mapper.findById(id);
        // 判断是否为空，若为空抛出异常
        if (jsPro == null)
            throw new RuntimeException("找不到此属性");
        return jsPro;
    }

    @Override
    public List<JsPro> findAll() {
        List<JsPro> list = mapper.findAll();
        // 判断集合是否为空
        if(list.size()<=0)
            throw new RuntimeException("无数据");
        return list;
    }

    @Transactional
    @Override
    public Integer insertOne(JsPro jsPro) {
        JsPro jsPro1 = mapper.findByName(jsPro.getProName());
        // 判断数据库是否有此属性
        if (jsPro1 != null)
            throw new RuntimeException("此属性已存在");
        Integer insertOne = mapper.insertOne(jsPro);
        // 添加失败抛异常
        if (insertOne<=0)
            throw new RuntimeException("添加失败，请重试");
        return insertOne;
    }

    @Override
    public Integer deleteOne(Integer id) {
        JsPro jsPro = mapper.findById(id);
        // 判断数据库是否有此数据
        if (jsPro == null)
            throw new RuntimeException("数据库找不到此数据，无需删除");
        Integer deleteOne = mapper.deleteOne(id);
        // 删除失败抛异常
        if (deleteOne <= 0)
            throw new RuntimeException("删除失败，请重试");
        return deleteOne;
    }

    @Transactional
    @Override
    public Integer updateOne(JsPro jsPro) {
        JsPro jsPro1 = mapper.findById(jsPro.getProId());
        // 判断数据库是否有此数据
        if (jsPro1 == null)
            throw new RuntimeException("数据库无此条数据");
        Integer updateOne = mapper.updateOne(jsPro);
        // 更新失败抛异常
        if (updateOne <= 0)
            throw new RuntimeException("更新失败，请重试");
        return updateOne;
    }
}
