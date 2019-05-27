package com.gdss.onlinevpsystem.controller;

import com.gdss.onlinevpsystem.entity.ExamQuestion;
import com.gdss.onlinevpsystem.service.ExamQuestionService;
import com.gdss.onlinevpsystem.vo.ResultUtil;
import com.gdss.onlinevpsystem.vo.ResultVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/examQuestion")
@RestController
public class ExamQuestionController {

    @Autowired
    private ExamQuestionService service;


    @GetMapping("/findByEid/{id}")
    @ApiOperation(value = "查询题目",notes = "根据试卷id查询题目")
    public ResultVO findByEid(@PathVariable("id")Integer id){
        List<ExamQuestion> list = service.findByEid(id);
        String msg = "查询成功";
        if (list.size() <=0 ){
            msg = "无数据";
        }
        return ResultUtil.success(msg,list);
    }

    @GetMapping("/findOne/{id}")
    @ApiOperation(value = "查询单个题目",notes = "根据id查询单个题目")
    public ResultVO findOne(@PathVariable("id")Integer id){
        ExamQuestion examQuestion = service.findById(id);
        return ResultUtil.success("成功",examQuestion);
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有题目",notes = "查询所有题目")
    public ResultVO findAll(){
        List<ExamQuestion> list = service.findAll();
        String msg = "成功";
        if (list.size() <=0 ){
            msg = "无数据";
        }
        return ResultUtil.success(msg,list);
    }

    @PostMapping("/insertOne")
    @ApiOperation(value = "添加新题目")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "qQuestion", value = "题目", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "qA", value = "选项A", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "qB", value = "选项B", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "qC", value = "选项C", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "qD", value = "选项D", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "eId", value = "属于试卷的试卷id", required = true,dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "qAnswer", value = "答案", required = true, dataType = "string", paramType = "query")
    }
    )
    public ResultVO insertOne(ExamQuestion examQuestion) throws Exception {
        Integer insertOne = service.insertOne(examQuestion);
        if (insertOne <= 0){
            throw new Exception("添加失败");
        }
        return ResultUtil.success("添加成功",insertOne);
    }

    @DeleteMapping("/deleteOne/{id}")
    @ApiOperation(value = "删除题目",notes = "根据id删除题目")
    public ResultVO deleteOne(@PathVariable("id")Integer id) throws Exception {
        Integer deleteOne = service.deleteOne(id);
        if(deleteOne <= 0){
            throw new Exception("删除失败");
        }
        return ResultUtil.success("删除成功",deleteOne);
    }

    @DeleteMapping("/deleteByEid/{id}")
    @ApiOperation(value = "删除题目",notes = "根据试卷id删除题目")
    public ResultVO deleteByEid(@PathVariable("id")Integer id) throws Exception {
        Integer deleteByEid = service.deleteByEid(id);
        if(deleteByEid <= 0){
            throw new Exception("删除失败");
        }
        return ResultUtil.success("删除成功",deleteByEid);
    }

    @PostMapping("/updateOne/{id}")
    @ApiOperation(value = "更新题目",notes = "根据传入的信息更新题目")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "qQuestion", value = "题目", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "qA", value = "选项A", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "qB", value = "选项B", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "qC", value = "选项C", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "qD", value = "选项D", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "eId", value = "属于试卷的试卷id", required = true,dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "qAnswer", value = "答案", required = true, dataType = "string", paramType = "query")
    })
    public ResultVO updateOne(@PathVariable("id")Integer id,ExamQuestion examQuestion) throws Exception {
        examQuestion.setQId(id);
        Integer updateById = service.updateById(examQuestion);
        if (updateById <= 0){
            throw new Exception("更新失败");
        }
        return ResultUtil.success("更新成功",updateById);
    }
}
