package com.gdss.onlinevpsystem.controller;

import com.gdss.onlinevpsystem.entity.Css;
import com.gdss.onlinevpsystem.enums.Status;
import com.gdss.onlinevpsystem.service.CssService;
import com.gdss.onlinevpsystem.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "CSS模块",description = "CSS模块的接口信息")
@RequestMapping("/css")
public class CssController {

    @Autowired
    private CssService service;

    @PostMapping("/save")
    @ApiOperation(value = "添加CSS属性",notes = "根据传入的信息添加属性")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cName", value = "标签名称", required = true,dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "cDesc", value = "标签描述", required = true,dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "cExample",value = "标签示例",required = true,dataType = "string",paramType = "query")
    })
    public Object save(Css css){
        Css save = service.save(css);
        ResultVO vo = new ResultVO();
        if (save!=null){
            vo.setCode(Status.SUCCESS.getCode());
            vo.setMsg("添加成功");
            vo.setData(save);
            return vo;
        }else {
            vo.setCode(Status.UNSUCCESS.getCode());
            vo.setMsg("添加失败");
            vo.setData(save);
            return vo;
        }
    }

    @GetMapping("/findall")
    @ApiOperation(value = "获取所有属性",notes = "分页获取所有属性")
    public Object findAll(){
        List<Css> list = service.findAll();
        ResultVO vo = new ResultVO();
        if (list != null) {
            vo.setCode(Status.SUCCESS.getCode());
            vo.setMsg("成功");
            vo.setData(list);
        }
        return vo;
    }

    @DeleteMapping("/delete/{cId}")
    @ApiOperation(value = "删除属性",notes = "根据cId删除对应的属性")
    public Object delete(@PathVariable(value = "cId")Integer cId){
        Css css = service.findById(cId);
        ResultVO v = new ResultVO();
        if ( css != null ){
            service.delete(cId);
            v.setCode(Status.SUCCESS.getCode());
            v.setData(null);
            v.setMsg("删除成功");
        }
        return v;
    }

    @GetMapping("/findById/{cId}")
    @ApiOperation(value = "查找css属性",notes = "根据cId查找css属性")
    public Object findById(@PathVariable(value = "cId")Integer cId){
        Css css = service.findById(cId);
        ResultVO vo = new ResultVO();
        if (css != null){
            vo.setCode(Status.SUCCESS.getCode());
            vo.setMsg("成功");
            vo.setData(css);
        }
        return vo;
    }
}
