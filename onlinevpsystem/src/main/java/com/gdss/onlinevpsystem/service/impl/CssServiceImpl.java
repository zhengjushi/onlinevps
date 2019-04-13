package com.gdss.onlinevpsystem.service.impl;

import com.gdss.onlinevpsystem.entity.Css;
import com.gdss.onlinevpsystem.repository.CssRepository;
import com.gdss.onlinevpsystem.service.CssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CssServiceImpl implements CssService {

    @Autowired
    private CssRepository repository;

    @Override
    public Css save(Css css) {
        return repository.save(css);
    }

    @Override
    public List<Css> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Integer cId) {
        repository.deleteById(cId);
    }

    @Override
    public Css findById(Integer cId) {
        return repository.findById(cId).orElse(null);
    }
}
