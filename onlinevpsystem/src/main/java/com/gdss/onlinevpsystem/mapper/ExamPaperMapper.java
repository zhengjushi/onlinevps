package com.gdss.onlinevpsystem.mapper;

import com.gdss.onlinevpsystem.entity.ExamPaper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamPaperMapper {

    @Select(value = "select * from exam_paper where e_id=#{id}")
    ExamPaper findOne(Integer id);

    @Select(value = "select e_id from exam_paper where e_title")
    ExamPaper findByTitle(String title);

    @Select(value = "select * from exam_paper")
    List<ExamPaper> findAll();

    @Insert(value = "insert into exam_paper (e_title) values(#{eTitle})")
    Integer insertOne(ExamPaper examPaper);

    @Delete(value = "delete from exam_paper where e_id=#{id}")
    Integer deleteOne(Integer id);

    @Update(value = "update exam_paper set e_title=#{eTitle} where e_id=#{eId}")
    Integer updateOne(ExamPaper examPaper);
}
