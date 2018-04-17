package com.example.canteen.dao;

import com.example.canteen.model.Orderdetail;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderDetailDao {

    @Select("select A.*, photo from orderdetail A INNER JOIN dish B " +
            "on A.dishId = B.id and A.`code` = #{code}")
    List<Orderdetail> findListByCode(@Param("code") String code);
}
