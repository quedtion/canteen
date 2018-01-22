package com.example.canteen.dao;

import com.example.canteen.model.Address;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AddressDao {

    @Select("select * from address where userId = #{userId} and deleted = 0")
    List<Address> findList(@Param("userId") int userId);
}
