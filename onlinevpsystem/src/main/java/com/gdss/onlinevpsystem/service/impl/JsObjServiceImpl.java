package com.gdss.onlinevpsystem.service.impl;

import com.gdss.onlinevpsystem.entity.JsObj;
import com.gdss.onlinevpsystem.mapper.JsObjMapper;
import com.gdss.onlinevpsystem.service.JsObjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JsObjServiceImpl implements JsObjService {

    @Autowired
    private JsObjMapper mapper;


    @Override
    public JsObj findById(Integer id) {
        JsObj jsObj = mapper.findById(id);
        if (jsObj == null)
            throw new RuntimeException("找不到此对象");
        return jsObj;
    }

    @Override
    public List<JsObj> findAll() {
        List<JsObj> list = mapper.findAll();
        if (list.size()<=0)
            throw new RuntimeException("无数据");
        return list;
    }

    @Transactional
    @Override
    public Integer insertOne(JsObj jsObj) {
        JsObj jsObj1 = mapper.findByName(jsObj.getObjName());
        if (jsObj1 != null)
            throw new RuntimeException("此对象已存在");
        Integer insertOne = mapper.insertOne(jsObj);
        if (insertOne <= 0)
            throw new RuntimeException("添加失败");
        return insertOne;
    }

    @Override
    public Integer deleteOne(Integer id) {
        JsObj jsObj = mapper.findById(id);
        if (jsObj == null)
            throw new RuntimeException("数据库找不到此数据，无需删除");
        Integer deleteOne = mapper.deleteOne(id);
        if (deleteOne <= 0)
            throw new RuntimeException("删除失败，请重试");
        return deleteOne;
    }

    @Transactional
    @Override
    public Integer updateOne(JsObj jsObj) {
        JsObj jsObj1 = mapper.findById(jsObj.getObjId());
        if (jsObj1 == null)
            throw new RuntimeException("数据库无此条数据");
        Integer updateOne = mapper.updateOne(jsObj);
        if (updateOne <= 0)
            throw new RuntimeException("更新失败，请重试");
        return updateOne;
    }
}
