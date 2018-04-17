package com.example.canteen.dao;

import com.example.canteen.model.Orders;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderDao {

    @Select("select * from orders where userId = #{userId}")
    List<Orders> findListById(@Param("userId") int userId);
}
