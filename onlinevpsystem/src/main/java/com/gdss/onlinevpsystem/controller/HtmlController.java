package com.gdss.onlinevpsystem.controller;

import com.gdss.onlinevpsystem.entity.Html;
import com.gdss.onlinevpsystem.service.HtmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HtmlController {

    @Autowired
    private HtmlService service;

    @GetMapping("/getHtmlById/{hId}")
    public Object getHtmlById(@PathVariable("hId")Integer hId){
        Map<String, Object> map = new HashMap<>();
        Html html = service.finById(hId);
        if (html != null){
            map.put("code",0);
            map.put("msg","成功");
            map.put("data",html);
            return map;
        }else {
            map.put("code",1);
            map.put("msg","失败");
            map.put("data",null);
            return map;
        }
    }

    @PostMapping("/save")
    public Object save(Html html){
        Map<String, Object> map = new HashMap<>();
        Html save = service.save(html);
        if (html != null){
            map.put("code",0);
            map.put("msg","添加成功");
            map.put("data",save);
            return map;
        }else {
            map.put("code", 1);
            map.put("msg", "添加失败");
            map.put("data", save);
            return map;
        }
    }

}
