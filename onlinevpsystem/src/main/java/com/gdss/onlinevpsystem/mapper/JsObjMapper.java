package com.gdss.onlinevpsystem.mapper;

import com.gdss.onlinevpsystem.entity.JsObj;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JsObjMapper {

    // 根据id查找
    @Select(value = "select * from js_obj where obj_id=#{id}")
    JsObj findById(Integer id);

    // 根据name查找
    @Select(value = "select obj_id from js_obj where obj_name=#{name}")
    JsObj findByName(String name);

    // 查找全部
    @Select(value = "select * from js_obj")
    List<JsObj> findAll();

    // 添加一行
    @Insert(value = "insert into js_obj (obj_name,obj_desc,obj_example) values(#{objName},#{objDesc},#{objExample})")
    Integer insertOne(JsObj jsObj);

    // 根据id删除
    @Delete(value = "delete from js_obj where obj_id=#{id}")
    Integer deleteOne(Integer id);

    // 根据id更新
    @Update(value = "update js_obj set obj_name=#{objName},obj_desc=#{objDesc},obj_example=#{objExample} where obj_id=#{objId}")
    Integer updateOne(JsObj jsObj);
}
