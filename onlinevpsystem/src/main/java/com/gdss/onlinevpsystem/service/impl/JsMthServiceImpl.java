package com.gdss.onlinevpsystem.service.impl;

import com.gdss.onlinevpsystem.entity.JsMth;
import com.gdss.onlinevpsystem.mapper.JsMthMapper;
import com.gdss.onlinevpsystem.service.JsMthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JsMthServiceImpl implements JsMthService {

    @Autowired
    private JsMthMapper mapper;


    @Override
    public JsMth findById(Integer id) {
        JsMth jsMth = mapper.findById(id);
        // 判断此方法是否存在
        if(jsMth == null)
            throw new RuntimeException("找不到此方法");
        return jsMth;
    }

    @Override
    public List<JsMth> findAll() {
        List<JsMth> list = mapper.findAll();
        // 判断是否无数据
        if (list.size()<=0)
            throw new RuntimeException("无数据");
        return list;
    }

    @Transactional
    @Override
    public Integer insertOne(JsMth jsMth) {
        JsMth jsMth1 = mapper.findByName(jsMth.getMthName());
        if (jsMth1 != null)
            throw new RuntimeException("此方法已存在，无需添加");
        Integer insertOne = mapper.insertOne(jsMth);
        if (insertOne <= 0)
            throw new RuntimeException("添加失败请重试");
        return insertOne;
    }

    @Override
    public Integer deleteOne(Integer id) {
        JsMth jsMth = mapper.findById(id);
        if (jsMth == null)
            throw new RuntimeException("此方法不存在，无需删除");
        Integer deleteOne = mapper.deleteOne(id);
        if (deleteOne <= 0)
            throw new RuntimeException("删除失败");
        return deleteOne;
    }

    @Transactional
    @Override
    public Integer updateOne(JsMth jsMth) {
        JsMth jsMth1 = mapper.findById(jsMth.getMthId());
        if (jsMth1 == null)
            throw new RuntimeException("找不到此方法");
        Integer updateOne = mapper.updateOne(jsMth);
        if (updateOne <= 0)
            throw new RuntimeException("更新失败");
        return updateOne;
    }
}
