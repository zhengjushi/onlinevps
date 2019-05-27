package com.gdss.onlinevpsystem.mapper;

import com.gdss.onlinevpsystem.entity.Html;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HtmlMapper {

    // 根据id查找
    @Select(value = "select * from html where h_id=#{id}")
    Html findById(Integer id);

    @Select(value = "select h_id from html where h_name=#{name}")
    Html findByName(String name);

    // 查找全部
    @Select(value = "select * from html")
    List<Html> findAll();

    // 添加一行
    @Insert(value = "insert into html (h_name,h_desc,h_example) values(#{hName},#{hDesc},#{hExample})")
    Integer insertOne(Html html);

    // 根据id删除
    @Delete(value = "delete from html where h_id=#{id}")
    Integer deleteOne(Integer id);

    // 根据id更新
    @Update(value = "update html set h_name=#{hName},h_desc=#{hDesc},h_example=#{hExample} where h_id=#{hId}")
    Integer updateOne(Html html);

}
