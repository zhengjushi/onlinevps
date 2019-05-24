package com.gdss.onlinevpsystem.service.impl;

import com.gdss.onlinevpsystem.entity.Html;
import com.gdss.onlinevpsystem.repository.HtmlRepository;
import com.gdss.onlinevpsystem.service.HtmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HtmlServiceImpl implements HtmlService {


    @Autowired
    private HtmlRepository repository;

    @Override
    public Html finById(Integer hId) {
        return repository.findById(hId).orElse(null);
    }

    @Override
    public Html save(Html html) {
        return repository.save(html);
    }

    @Override
    public Page<Html> findAll(PageRequest pageRequest) {
        return repository.findAll(pageRequest);
    }

    @Override
    public List<Html> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Integer hId) {
        repository.deleteById(hId);
    }


}
