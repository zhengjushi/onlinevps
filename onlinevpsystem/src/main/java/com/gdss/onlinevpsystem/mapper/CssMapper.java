package com.gdss.onlinevpsystem.mapper;

import com.gdss.onlinevpsystem.entity.Css;
import org.apache.ibatis.annotations.*;
import java.util.List;


public interface CssMapper {

    // 根据id查找css
    @Select(value = "select * from css where c_id=#{id}")
    Css findById(Integer id);

    @Select(value = "select c_id from css where c_name=#{name}")
    Css findByName(String name);

    // 查找全部
    @Select(value = "select * from css")
    List<Css> findAll();

    // 添加
    @Insert(value = "insert into css (c_name,c_desc,c_example) values(#{cName},#{cDesc},#{cExample})")
    Integer insertOne(Css css);

    // 根据id删除
    @Delete(value = "delete from css where c_id=#{id}")
    Integer deleteOne(Integer id);

    // 根据id更新
    @Update(value = "update css set c_name=#{cName},c_desc=#{cDesc},c_example=#{cExample} where c_id=#{cId}")
    Integer updateOne(Css css);

}
