package com.gdss.onlinevpsystem.controller;

import com.gdss.onlinevpsystem.entity.BaseEntity;
import com.gdss.onlinevpsystem.entity.JsMth;
import com.gdss.onlinevpsystem.service.JsMthService;
import com.gdss.onlinevpsystem.vo.ResultUtil;
import com.gdss.onlinevpsystem.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value = "js 方法模块",description = "js对象的方法模块")
@RequestMapping("/js/mth")
public class JsMthController {

    @Autowired
    private JsMthService service;

    @ApiOperation(value = "查询单个js方法",notes = "根据id查询单个方法")
    @GetMapping("/findById/{id}")
    public ResultVO findById(@PathVariable("id")Integer id){
        JsMth jsMth = service.findById(id);
        BaseEntity baseEntity = new BaseEntity(jsMth.getMthId(),jsMth.getMthName(),jsMth.getMthDesc(),jsMth.getMthExample());
        return ResultUtil.success("查询成功",baseEntity);
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有js方法")
    public ResultVO findAll(){
        List<JsMth> list = service.findAll();
        // 转换未统一格式
        List<BaseEntity> list1 = new ArrayList<>();
        for (int i=0; i<list.size(); i++){
            JsMth jsMth = list.get(i);
            list1.add(new BaseEntity(jsMth.getMthId(),jsMth.getMthName(),jsMth.getMthDesc(),jsMth.getMthExample()));
        }
        return ResultUtil.success("查询成功",list1);
    }

    @PostMapping("/insertOne")
    @ApiOperation(value = "添加js方法")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name" ,value = "方法名",required = true,dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "desc" ,value = "方法描述" ,required = true, dataType = "string" ,paramType = "query"),
            @ApiImplicitParam(name = "example" ,value = "方法示例" ,required = true ,dataType = "string" ,paramType = "query")
    })
    public ResultVO insertOne(@RequestParam("name")String name,@RequestParam("desc")String desc,@RequestParam("example")String example){
        JsMth jsMth = new JsMth(name,desc,example);
        service.insertOne(jsMth);
        return ResultUtil.success("添加成功");
    }

    @DeleteMapping("/deleteOne/{id}")
    @ApiOperation(value = "删除一个js方法",notes = "根据id删除js方法")
    public ResultVO deleteOne(@PathVariable("id")Integer id){
        service.deleteOne(id);
        return ResultUtil.success("删除成功");
    }

    @PostMapping("/updateOne/{id}")
    @ApiOperation(value = "更新一个方法")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name" ,value = "方法名",required = true,dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "desc" ,value = "方法描述" ,required = true, dataType = "string" ,paramType = "query"),
            @ApiImplicitParam(name = "example" ,value = "方法示例" ,required = true ,dataType = "string" ,paramType = "query")
    })
    public ResultVO updateOne(@PathVariable("id")Integer id,@RequestParam("name")String name,@RequestParam("desc")String desc,@RequestParam("example")String example){
        JsMth jsMth = new JsMth(id,name,desc,example);
        service.updateOne(jsMth);
        return ResultUtil.success("更新成功");
    }

}
