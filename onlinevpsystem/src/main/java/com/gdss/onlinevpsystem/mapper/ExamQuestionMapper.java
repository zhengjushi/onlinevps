package com.gdss.onlinevpsystem.mapper;

import com.gdss.onlinevpsystem.entity.ExamQuestion;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamQuestionMapper {

    @Select(value = "select * from exam_question where e_id=#{id}")
    List<ExamQuestion> findByEid(Integer id);

    @Select(value = "select q_id from exam_question where q_question=#{question}")
    ExamQuestion findByQquestion(String question);

    @Select(value = "select * from exam_question where q_id=#{id}")
    ExamQuestion findById(Integer id);

    @Select(value = "select * from exam_question")
    List<ExamQuestion> findAll();

    @Insert(value = "insert into exam_question (q_question,q_a,q_b,q_c,q_d,e_id,q_answer) " +
            "values(#{qQuestion},#{qA},#{qB},#{qC},#{qD},#{eId},#{qAnswer})")
    Integer insertOne(ExamQuestion examQuestion);

    @Delete(value = "delete from exam_question where q_id=#{id}")
    Integer deleteOne(Integer id);

    @Delete(value = "delete from exam_question where e_id=#{id}")
    Integer deleteByEid(Integer id);

    @Update(value = "update exam_question set " +
            "q_question=#{qQuestion},q_a=#{qA},q_b=#{qB},q_c=#{qC},q_d=#{qD},q_answer=#{qAnswer} " +
            "where q_id=#{qId}")
    Integer updateById(ExamQuestion examQuestion);

}
