package com.example.canteen.dao;

import com.example.canteen.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

    @Select("select * from user where id = #{id} and deleted = 0;")
    List<User> findById(@Param("id") int id);
}
