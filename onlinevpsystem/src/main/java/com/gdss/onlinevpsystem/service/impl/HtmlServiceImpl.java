package com.gdss.onlinevpsystem.service.impl;

import com.gdss.onlinevpsystem.entity.Html;
import com.gdss.onlinevpsystem.repository.HtmlRepository;
import com.gdss.onlinevpsystem.service.HtmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HtmlServiceImpl implements HtmlService {

    @Autowired
    private HtmlRepository repository;

    @Override
    public Html finById(Integer hId) {
        return repository.findById(hId).orElse(null);
    }
}
