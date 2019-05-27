package com.gdss.onlinevpsystem.controller;

import com.gdss.onlinevpsystem.entity.BaseEntity;
import com.gdss.onlinevpsystem.entity.JsPro;
import com.gdss.onlinevpsystem.service.JsProService;
import com.gdss.onlinevpsystem.vo.ResultUtil;
import com.gdss.onlinevpsystem.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value = "js 属性模块",description = "js的属性模块")
@RequestMapping("/js/pro")
public class JsProController {

    @Autowired
    private JsProService service;

    @ApiOperation(value = "查找单个 js 属性",notes = "根据 id 查找单个属性")
    @GetMapping("/findById/{id}")
    public ResultVO findById(@PathVariable("id")Integer id){
        JsPro jsPro = service.findById(id);

        BaseEntity baseEntity = new BaseEntity(jsPro.getProId(),jsPro.getProName(),jsPro.getProDesc(),jsPro.getProExample());
        return ResultUtil.success("查询成功",baseEntity);
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有",notes = "查询所有 js 的属性")
    public ResultVO findAll(){
        List<JsPro> list = service.findAll();

        //转换为统一格式
        List<BaseEntity> list1 = new ArrayList<>();
        for (int i=0; i<list.size(); i++){
            JsPro jsPro = list.get(i);
            list1.add(new BaseEntity(jsPro.getProId(),jsPro.getProName(),jsPro.getProDesc(),jsPro.getProExample()));
        }

        return ResultUtil.success("查询成功",list1);
    }

    @Transactional
    @PostMapping("/insertOne")
    @ApiOperation(value = "添加 js 属性",notes = "根据传入的信息添加 js 属性")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "属性名", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "desc", value = "属性描述", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "example", value = "属性示例", required = true, dataType = "string", paramType = "query")
    }
    )
    public ResultVO insertOne(@RequestParam("name")String name,@RequestParam("desc")String desc,@RequestParam("example")String example){
        JsPro jsPro = new JsPro(name,desc,example);
        Integer insertOne = service.insertOne(jsPro);
        return ResultUtil.success("插入成功",insertOne);
    }

    @DeleteMapping("/deleteOne/{id}")
    @ApiOperation(value = "删除 js 属性",notes = "根据 id 删除指定的 js 属性")
    public ResultVO deleteOne(@PathVariable("id")Integer id){
        Integer deleteOne = service.deleteOne(id);
        return ResultUtil.success("删除成功",deleteOne);
    }


    @Transactional
    @PostMapping("/updateOne/{id}")
    @ApiOperation(value = "更新 js 属性",notes = "根据传入的信息更新数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "属性名", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "desc", value = "属性描述", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "example", value = "属性示例", required = true, dataType = "string", paramType = "query")
    })
    public ResultVO updateOne(@PathVariable("id")Integer id,@RequestParam("name")String name,@RequestParam("desc")String desc,@RequestParam("example")String example){
        JsPro jsPro = new JsPro(id,name,desc,example);
        Integer updateOne = service.updateOne(jsPro);
        return ResultUtil.success("更新成功",updateOne);
    }
}
