package com.gdss.onlinevpsystem.mapper;

import com.gdss.onlinevpsystem.entity.JsPro;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JsProMapper {

    // 根据id查找
    @Select(value = "select * from js_pro where pro_id=#{id}")
    JsPro findById(Integer id);

    // 根据name查找
    @Select(value = "select pro_id from js_pro where pro_name=#{name}")
    JsPro findByName(String name);

    // 查找全部
    @Select(value = "select * from js_pro")
    List<JsPro> findAll();

    // 添加一行
    @Insert(value = "insert into js_pro (pro_name,pro_desc,pro_example) values(#{proName},#{proDesc},#{proExample})")
    Integer insertOne(JsPro jsPro);

    // 根据id删除
    @Delete(value = "delete from js_pro where pro_id=#{id}")
    Integer deleteOne(Integer id);

    // 根据id更新
    @Update(value = "update js_pro set pro_name=#{proName},pro_desc=#{proDesc},pro_example=#{proExample} where pro_id=#{proId}")
    Integer updateOne(JsPro jsPro);


}
