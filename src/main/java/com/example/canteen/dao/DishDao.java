package com.example.canteen.dao;

import com.example.canteen.model.Dish;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DishDao {

    /**
     * 根据食堂id查询菜品信息列表
     * @param canteenId 食堂id
     * @return 菜品信息list
     */
    @Select("select * from dish where canteenId = #{canteenId} and deleted = 0;")
    List<Dish> findListByCanteenId(@Param("canteenId") int canteenId);

    /**
     * 根据菜品id更新销售量
     * @param dishId 菜品id
     * @param count 增量
     * @return
     */
    @Update("update dish set salesVolume = salesVolume + #{count} where id = #{dishId};")
    int updateCount(@Param("dishId") int dishId, @Param("count") int count);

    @Select("select * from dish where deleted = 0")
    List<Dish> findList();

    @Select("select * from dish where deleted = 0 order by salesVolume desc limit #{count}")
    List<Dish> findRankingList(@Param("count") int count);

}
