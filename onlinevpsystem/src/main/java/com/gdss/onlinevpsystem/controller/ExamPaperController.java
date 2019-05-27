package com.gdss.onlinevpsystem.controller;

import com.gdss.onlinevpsystem.entity.ExamPaper;
import com.gdss.onlinevpsystem.service.ExamPaperService;
import com.gdss.onlinevpsystem.vo.ResultUtil;
import com.gdss.onlinevpsystem.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examPaper")
@Api(value = "试卷模块",description = "试卷模块的接口信息")
public class ExamPaperController {

    @Autowired
    private ExamPaperService service;

    @GetMapping("/findOne/{id}")
    @ApiOperation(value = "查询试卷",notes = "根据id查询试卷")
    public ResultVO findOne(@PathVariable Integer id){
        ExamPaper examPaper = service.findOne(id);
        String msg = "查询成功";
        if (examPaper == null){
            msg = "查询不到本数据";
        }
        return ResultUtil.success(msg,examPaper);
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有试卷",notes = "分页查询所有")
    public ResultVO findAll(){
        List<ExamPaper> all = service.findAll();
        String msg = "插叙成功";
        if (all.size() <= 0){
            msg = "无数据";
        }
        return ResultUtil.success(msg,all);
    }

    @PostMapping("/insertOne")
    @ApiOperation(value = "添加新试卷",notes = "根据传入的信息添加试卷")
    @ApiImplicitParam(name = "eTitle",value = "试卷名",required = true,dataType = "string", paramType = "query")
    public ResultVO insertOne(@RequestParam("eTitle")String eTitle){
        ExamPaper examPaper = new ExamPaper();
        examPaper.setETitle(eTitle);
        Integer insertOne = service.insertOne(examPaper);
        String msg = "添加成功";
        if (insertOne <= 0){
            msg = "添加失败";
        }
        return ResultUtil.success(msg,insertOne);
    }

    @DeleteMapping("/deleteOne/{eId}")
    @ApiOperation(value = "删除试卷",notes = "根据id删除试卷")
    public ResultVO deleteOne(@PathVariable("eId")Integer id){
        Integer deleteOne = service.deleteOne(id);
        String msg = "删除成功";
        if (deleteOne <= 0){
            msg = "本条数据不存在，无需删除";
        }
        return ResultUtil.success(msg,deleteOne);
    }

    @PostMapping("/updateOne/{eId}")
    @ApiOperation(value = "更新试卷",notes = "根据id更新试卷")
    @ApiImplicitParam(name = "etitle",value = "试卷名",required = true,dataType = "string", paramType = "query")
    public ResultVO updateOne(@PathVariable("eId")Integer eId,@RequestParam("etitle")String eTitle){
        ExamPaper examPaper = new ExamPaper(eId,eTitle);
        Integer result = service.updateOne(examPaper);
        String msg = "更新成功";
        return ResultUtil.success(msg,result);
    }

}
