package com.gdss.onlinevpsystem.service.impl;

import com.gdss.onlinevpsystem.entity.Css;
import com.gdss.onlinevpsystem.mapper.CssMapper;
import com.gdss.onlinevpsystem.service.CssService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class CssServiceImpl implements CssService {

    @Autowired
    private CssMapper mapper;

    @Override
    public Css findById(Integer id) {
        Css css = mapper.findById(id);

        if (css == null) {
            log.info(this.getClass().getName()+".findById() --->查询css失败");
            throw new RuntimeException("找不到此数据");
        }
        log.info(this.getClass().getName()+".findById()--->查询css成功 --> "+css);
        return css;
    }

    @Override
    public List<Css> findAll() {
        List<Css> list = mapper.findAll();
        if (list.size()<=0) {
            log.info(this.getClass().getName()+".findAll()--->查询失败");
            throw new RuntimeException("无数据");
        }
        log.info(this.getClass().getName()+".findAll()--->查询全部css成功 ");
        return list;
    }

    @Transactional
    @Override
    public Integer insertOne(Css css) {
        Css css1 = mapper.findByName(css.getCName());
        if (css1 != null)
            throw new RuntimeException("此数据已存在");
        Integer result = mapper.insertOne(css);
        if (result <= 0)
            throw new RuntimeException("添加失败");
        log.info("增加一条数据 --> "+result);
        return result;
    }

    @Transactional
    @Override
    public Integer deleteOne(Integer id) {
        Css css = mapper.findById(id);
        if(css == null)
            throw new RuntimeException("找不到此数据");
        Integer result = mapper.deleteOne(id);
        if (result <= 0)
            throw new RuntimeException("删除失败，请重试");
        log.info("根据id删除一条数据 --> "+result);
        return result;
    }

    @Transactional
    @Override
    public Integer updateOne(Css css) {
        Css css1 = mapper.findById(css.getCId());
        if (css1 == null)
            throw new RuntimeException("找不到此数据");
        Integer result = mapper.updateOne(css);
        if (result <= 0)
            throw new RuntimeException("更新失败，请重试");
        log.info("更新数据 --> "+result+" 条");
        return result;
    }
}
