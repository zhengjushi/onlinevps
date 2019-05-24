package com.gdss.onlinevpsystem.controller;

import com.gdss.onlinevpsystem.entity.Html;
import com.gdss.onlinevpsystem.enums.Status;
import com.gdss.onlinevpsystem.service.HtmlService;
import com.gdss.onlinevpsystem.vo.ResultVO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "HTML模块",description = "HTML模块的接口信息")
@RequestMapping("/html")
public class HtmlController {

    @Autowired
    private HtmlService service;

    // 查询单个Html
    @ApiOperation(value = "获取标签信息",notes = "根据id获取标签信息")
    @ApiImplicitParam(value = "标签ID",paramType = "path")
    @GetMapping("/getHtmlById/{hId}")
    public Object getHtmlById(@PathVariable("hId")Integer hId){
        Html html = service.finById(hId);
        ResultVO vo = new ResultVO();
        if (html != null){
            vo.setCode(Status.SUCCESS.getCode());
            vo.setMsg("获取成功");
            vo.setData(html);
            return vo;
        }else {
            vo.setCode(1);
            vo.setMsg("获取失败");
            vo.setData(html);
            return vo;
        }
    }

    // 增
    @ApiOperation(value = "添加HTML标签",notes = "根据传入的信息添加标签")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hName", value = "标签名称", required = true,dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "hDesc", value = "标签描述", required = true,dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "hExample",value = "标签示例",required = true,dataType = "string",paramType = "query")
    })
    @PostMapping("/save")
    public Object save(Html html){
        Html save = service.save(html);
        ResultVO vo = new ResultVO();
        if (save != null){
            vo.setCode(Status.SUCCESS.getCode());
            vo.setMsg("成功");
            vo.setData(save);
            return vo;
        }else {
            vo.setCode(Status.UNSUCCESS.getCode());
            vo.setMsg("添加失败");
            vo.setData(save);
            return vo;
        }
    }

    // 分页
    @GetMapping("/findall")
    @ApiOperation(value = "获取所有标签",notes = "分页获取所有标签")
    public Object findAll( ){
        List<Html> list = service.findAll();
        ResultVO vo = new ResultVO();
        if (list != null) {
            vo.setCode(Status.SUCCESS.getCode());
            vo.setMsg("成功");
            vo.setData(list);
        }
        return vo;
    }


    @DeleteMapping("/delete/{hId}")
    @ApiImplicitParam(value = "标签ID",paramType = "path")
    public Object delete(@PathVariable("hId")Integer hId){
        Html html = service.finById(hId);
        ResultVO vo = new ResultVO();
        if (html != null) {
            service.delete(hId);
            vo.setCode(Status.SUCCESS.getCode());
            vo.setMsg("删除成功");
            vo.setData(null);
        }
        return vo;
    }


}
