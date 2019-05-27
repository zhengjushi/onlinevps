package com.gdss.onlinevpsystem.controller;

import com.gdss.onlinevpsystem.entity.BaseEntity;
import com.gdss.onlinevpsystem.entity.JsObj;
import com.gdss.onlinevpsystem.service.JsObjService;
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
@RequestMapping("/js/obj") //js 的对象接口
@Api(value = "js模块",description = "js模块的对象接口信息")
public class JsObjController {

    @Autowired
    private JsObjService service;

    @GetMapping("/findById/{id}")
    @ApiOperation(value = "查找单个 js 的对象",notes = "根据id查找")
    public ResultVO findById(@PathVariable("id")Integer id){
        JsObj jsObj = service.findById(id);
        BaseEntity baseEntity = new BaseEntity(jsObj.getObjId(),jsObj.getObjName(),jsObj.getObjDesc(),jsObj.getObjExample());
        return ResultUtil.success("查询成功",baseEntity);
    }


    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有",notes = "查询所有 js 的对象")
    public ResultVO findAll(){
        List<JsObj> list = service.findAll();

        // 转换为统一格式
        List<BaseEntity> list1 = new ArrayList<>();
        for (int i=0; i<list.size(); i++){
            JsObj jsObj = list.get(i);
            list1.add(new BaseEntity(jsObj.getObjId(),jsObj.getObjName(),jsObj.getObjDesc(),jsObj.getObjExample()));
        }

        return ResultUtil.success("查询成功",list1);
    }

    @Transactional
    @PostMapping("/insertOne")
    @ApiOperation(value = "添加 js 对象",notes = "根据传入的信息添加 js 对像")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "对象名", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "desc", value = "对象描述", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "example", value = "对象示例", required = true, dataType = "string", paramType = "query")
        }
    )
    public ResultVO insertOne(@RequestParam("name")String objName,@RequestParam("desc")String objDesc,@RequestParam("example")String objExample){
        JsObj jsObj = new JsObj(objName,objDesc,objExample);
        service.insertOne(jsObj);
        return ResultUtil.success("插入成功");
    }

    @DeleteMapping("/deleteOne/{id}")
    @ApiOperation(value = "删除 js 对象",notes = "根据 id 删除指定的 js 对象")
    public ResultVO deleteOne(@PathVariable("id")Integer id){
        service.deleteOne(id);
        return ResultUtil.success("删除成功");
    }

    @Transactional
    @PostMapping("/updateOne/{id}")
    @ApiOperation(value = "更新 js 对象",notes = "根据传入的信息更新数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "对象名", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "desc", value = "对象描述", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "example", value = "对象示例", required = true, dataType = "string", paramType = "query")
    })
    public ResultVO updateOne(@PathVariable("id")Integer id,@RequestParam("name")String objName,@RequestParam("desc")String objDesc,@RequestParam("example")String objExample){
        JsObj jsObj = new JsObj(id,objName,objDesc,objExample);
         service.updateOne(jsObj);
        return ResultUtil.success("更新成功");
    }



}
