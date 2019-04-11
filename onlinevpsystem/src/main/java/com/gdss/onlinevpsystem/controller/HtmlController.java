package com.gdss.onlinevpsystem.controller;

import com.gdss.onlinevpsystem.entity.Html;
import com.gdss.onlinevpsystem.service.HtmlService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(value = "HTML模块",description = "HTML模块的接口信息")
public class HtmlController {

    @Autowired
    private HtmlService service;

    @ApiOperation(value = "获取标签信息",notes = "根据id获取标签信息")
    @ApiImplicitParam(value = "用户ID",paramType = "path")
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

    @ApiOperation(value = "添加HTML标签",notes = "根据传入的信息添加标签")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hName", value = "标签名称", required = true,dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "hDesc", value = "标签描述", required = true,dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "hExample",value = "标签示例",required = true,dataType = "string",paramType = "query")
    })
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

    @GetMapping("/findall/{pageNumber}")
    @ApiOperation(value = "获取所有标签",notes = "分页获取所有标签")
    @ApiImplicitParam(value = "页码",paramType = "path")
    public Object findAll(@PathVariable("pageNumber")Integer pageNumber){
        Page<Html> page = service.findAll(PageRequest.of(pageNumber,2));
        Map<String,Object> map = new HashMap<>();
        map.put("page",page);
        map.put("code",0);
        map.put("msg","成功");
        return map;
    }


}
