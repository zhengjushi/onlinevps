package com.gdss.onlinevpsystem.controller;

import com.gdss.onlinevpsystem.entity.BaseEntity;
import com.gdss.onlinevpsystem.entity.Css;
import com.gdss.onlinevpsystem.service.CssService;
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

@RequestMapping("/css")
@Api(value = "CSS模块",description = "CSS模块的接口信息")
@RestController
public class CssController {

    @Autowired
    private CssService service;

    @GetMapping("/findById/{id}")
    @ApiOperation(value = "查找css属性",notes = "根据cId查找css属性")
    public ResultVO findById(@PathVariable("id")Integer id){
        Css c  = service.findById(id);

        // 转换为统一格式的 BaseEntity 方便前端调用
        BaseEntity b = new BaseEntity(c.getCId(),c.getCName(),c.getCDesc(),c.getCExample());

        String msg = "查询成功";
        if(c == null){
            msg="此属性不存在";
        }
        return ResultUtil.success(msg,b);
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "获取所有属性",notes = "分页获取所有属性")
    public ResultVO findAll(){
        List<Css> list = service.findAll();

        // 转换为统一格式的 BaseEntity 方便前端调用
        List<BaseEntity> list1 = new ArrayList<>();
        for (int i = 0; i < list.size() ;i++){
            Css css = list.get(i);
            list1.add(new BaseEntity(css.getCId(),css.getCName(),css.getCDesc(),css.getCExample()));
        }

        String msg = "查询成功";
        if (list.size()==0){
            msg = "没有数据,请添加数据";
        }
        return ResultUtil.success(msg,list1);
    }

    @Transactional
    @PostMapping("/insertOne")
    @ApiOperation(value = "添加CSS属性",notes = "根据传入的信息添加属性")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "标签名称", required = true,dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "desc", value = "标签描述", required = true,dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "example",value = "标签示例",required = true,dataType = "string",paramType = "query")
    })
    public ResultVO insertOne(@RequestParam("name")String cName,@RequestParam("desc")String cDesc,@RequestParam("example")String cExample){
        Css css = new Css();
        css.setCName(cName);
        css.setCDesc(cDesc);
        css.setCExample(cExample);
        Integer result = service.insertOne(css);
        String msg = "添加成功";
        if (result <= 0){
            throw new RuntimeException("添加失败");
        }
        return ResultUtil.success(msg,result);
    }

    @Transactional
    @DeleteMapping("/deleteOne/{id}")
    @ApiOperation(value = "删除属性",notes = "根据cId删除对应的属性")
    public ResultVO deleteOne(@PathVariable("id") Integer id){
        Integer result = service.deleteOne(id);
        String msg = "删除成功";
        if (result <=0 ){
            msg = "本条数据不存在，无需删除";
        }
        return ResultUtil.success(msg,result);
    }

    @Transactional
    @PostMapping("/updateOne/{id}")
    @ApiOperation(value = "添加CSS属性",notes = "根据传入的信息添加属性")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "属性名称", required = true,dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "desc", value = "属性描述", required = true,dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "example",value = "属性示例",required = true,dataType = "string",paramType = "query")
    })
    public ResultVO updateOne(@PathVariable("id")Integer cId,@RequestParam("name")String cName,@RequestParam("desc")String cDesc,@RequestParam("example")String cExample){
        Css css = new Css();
        css.setCId(cId);
        css.setCName(cName);
        css.setCDesc(cDesc);
        css.setCExample(cExample);
        Integer result = service.updateOne(css);
        String msg = "更新成功";
        /*if(result <=0 ){
            msg = "修改内容与原数据一致,请重新修改";
        }*/
        return ResultUtil.success(msg,result);
    }
}
