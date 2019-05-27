package com.gdss.onlinevpsystem.controller;

import com.gdss.onlinevpsystem.entity.BaseEntity;
import com.gdss.onlinevpsystem.entity.Html;
import com.gdss.onlinevpsystem.service.HtmlService;
import com.gdss.onlinevpsystem.vo.ResultUtil;
import com.gdss.onlinevpsystem.vo.ResultVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/html")
@RestController
public class HtmlController {

    @Autowired
    private HtmlService service;

    @GetMapping("/findOne/{id}")
    @ApiOperation(value = "查找HTML标签",notes = "根据hId查找html标签")
    public ResultVO findOne(@PathVariable("id")Integer id){
        Html html = service.findById(id);
        BaseEntity baseEntity = new BaseEntity(html.getHId(),html.getHName(),html.getHDesc(),html.getHExample());
        String msg = "查询成功";
        if(html == null){
            msg="此标签不存在";
        }
        return ResultUtil.success(msg,baseEntity);
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "获取所有标签",notes = "分页获取所有标签")
    public ResultVO findAll(){
        List<Html> list = service.findAll();

        // 转换为统一格式的 BaseEntity 方便前端调用
        List<BaseEntity> list1 = new ArrayList<>();
        for (int i = 0; i < list.size() ;i++){
            Html html = list.get(i);
            list1.add(new BaseEntity(html.getHId(),html.getHName(),html.getHDesc(),html.getHExample()));
        }

        String msg = "查询成功";
        if (list.size()==0){
            msg = "没有数据,请添加数据";
        }
        return ResultUtil.success(msg,list1);
    }


    @Transactional
    @PostMapping("/insertOne")
    @ApiOperation(value = "添加HTML标签",notes = "根据传入的信息添加标签")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "标签名称", required = true,dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "desc", value = "标签描述", required = true,dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "example",value = "标签示例",required = true,dataType = "string",paramType = "query")
    })
    public ResultVO insertOne(@RequestParam("name")String hName,@RequestParam("desc")String hDesc,@RequestParam("example")String hExample){
        Html html = new Html(hName,hDesc,hExample);
        Integer insertOne = service.insertOne(html);
        String msg = "添加成功";
        if(insertOne <= 0){
            throw new RuntimeException("添加失败");
        }
        return ResultUtil.success(msg,insertOne);
    }

    @Transactional
    @DeleteMapping("/deleteOne/{id}")
    @ApiOperation(value = "删除标签",notes = "根据id删除标签")
    public ResultVO deleteOne(@PathVariable("id")Integer id){
        Integer deleteOne = service.deleteOne(id);
        String msg = "删除成功";
        if (deleteOne == 0){
            msg = "本条数据不存在,无需删除";
        }
        return ResultUtil.success(msg,deleteOne);
    }

    @Transactional
    @PostMapping("/updateOne/{id}")
    @ApiOperation(value = "更新HTML标签",notes = "根据传入的信息更新属性")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "标签名称", required = true,dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "desc", value = "标签描述", required = true,dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "example",value = "标签示例",required = true,dataType = "string",paramType = "query")
    })
    public ResultVO updateOne(@PathVariable("id")Integer hId,@RequestParam("name")String hName,@RequestParam("desc")String hDesc,@RequestParam("example")String hExample) throws Exception {
        Html html = new Html(hId,hName,hDesc,hExample);
        Integer updateOne = service.updateOne(html);

        if (updateOne <= 0){
            throw new Exception("更新失败");
        }
        return ResultUtil.success("更新成功",updateOne);
    }

}
