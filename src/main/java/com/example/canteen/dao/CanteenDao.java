package com.example.canteen.dao;

import com.example.canteen.model.Canteen;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CanteenDao {

    @Select("select * from canteen where deleted = 0;")
    List<Canteen> findList();

    @Select("select * from canteen where name = #{name} and deleted = 0;")
    List<Canteen> findByName(@Param("name") String name);

    @Select("select * from canteen where (name = #{name} or id = #{id}) and deleted = 0;")
    List<Canteen> findByIdOrName(@Param("name") String name, @Param("id") int id);

    @Select("select * from canteen where id = #{id} and deleted = 0;")
    Canteen findById(@Param("id") int id);
}
