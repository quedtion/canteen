package com.example.canteen.dao;

import com.example.canteen.model.Canteen;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CanteenDao {

    /**
     * 查询所有有效的食堂信息列表
     * @return 食堂信息list
     */
    @Select("select * from canteen where deleted = 0;")
    List<Canteen> findList();

    /**
     * 根据食堂id获取商家列表
     * @param hallId
     * @return
     */
    @Select("select * from canteen where deleted = 0 and hallId = #{hallId};")
    List<Canteen> findListHallId(@Param("hallId") int hallId);

    /**
     * 根据食堂名称查询食堂信息列表（新增食堂信息时名称验重）
     * @param name 食堂名称
     * @return 食堂信息list
     */
    @Select("select * from canteen where name = #{name} and deleted = 0;")
    List<Canteen> findByName(@Param("name") String name);

    /**
     * 根据id 或食堂名称查询食堂信息列表（修改食堂信息时名称验重）
     * @param name 食堂名称
     * @param id 主键
     * @return 食堂信息list
     */
    @Select("select * from canteen where (name = #{name} or id = #{id}) and deleted = 0;")
    List<Canteen> findByIdOrName(@Param("name") String name, @Param("id") int id);

    /**
     * 根据id查询有效的食堂信息
     * @param id 主键id
     * @return 食堂信息model
     */
    @Select("select * from canteen where id = #{id} and deleted = 0;")
    Canteen findById(@Param("id") int id);
}
