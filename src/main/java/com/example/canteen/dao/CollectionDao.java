package com.example.canteen.dao;

import com.example.canteen.model.Mycollection;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CollectionDao {

    /**
     * 根据用户id查询收藏列表
     * @param userId
     * @return
     */
    @Select("select * from myCollection where userId = #{userId} and deleted = 0;")
    List<Mycollection> findList(@Param("userId") Integer userId);
}
