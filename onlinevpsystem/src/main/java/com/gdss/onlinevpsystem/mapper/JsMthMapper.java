package com.gdss.onlinevpsystem.mapper;

import com.gdss.onlinevpsystem.entity.JsMth;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JsMthMapper {

    // 根据id查找
    @Select(value = "select * from js_mth where mth_id=#{id}")
    JsMth findById(Integer id);

    // 根据name查找方法
    @Select(value = "select mth_id from js_mth where mth_name=#{name} ")
    JsMth findByName(String name);

    // 查找全部
    @Select(value = "select * from js_mth")
    List<JsMth> findAll();

    // 添加一行
    @Insert(value = "insert into js_mth (mth_name,mth_desc,mth_example) values(#{mthName},#{mthDesc},#{mthExample})")
    Integer insertOne(JsMth jsMth);

    // 根据id删除
    @Delete(value = "delete from js_mth where mth_id=#{id}")
    Integer deleteOne(Integer id);

    // 根据id更新
    @Update(value = "update js_mth set mth_name=#{mthName},mth_desc=#{mthDesc},mth_example=#{mthExample} where mth_id=#{mthId}")
    Integer updateOne(JsMth jsMth);

}
