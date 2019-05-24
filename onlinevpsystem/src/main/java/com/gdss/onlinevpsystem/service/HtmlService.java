package com.gdss.onlinevpsystem.service;

import com.gdss.onlinevpsystem.entity.Html;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface HtmlService {

    Html finById(Integer hId);

    Html save(Html html);

    Page<Html> findAll(PageRequest pageRequest);

    List<Html> findAll();

    void delete(Integer hId);
}
