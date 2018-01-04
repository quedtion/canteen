package com.example.canteen.dao;

import com.example.canteen.model.Dish;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DishDao {

    /**
     * 根据食堂id查询菜品信息列表
     * @param canteenId 食堂id
     * @return 菜品信息list
     */
    @Select("select * from dish where canteenId = #{canteenId} and deleted = 0;")
    List<Dish> findListByCanteenId(@Param("canteenId") int canteenId);
}
