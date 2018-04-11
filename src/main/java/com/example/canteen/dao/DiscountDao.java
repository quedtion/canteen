package com.example.canteen.dao;

import com.example.canteen.model.Discount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.DateTimeException;
import java.util.Date;

public interface DiscountDao {

    /**
     * 根据id获取当前有效的打折信息
     * @param id
     * @return
     */
    @Select("select * from discount where deleted = 0 and id = #{id}")
    Discount findById(@Param("id") int id);
}
