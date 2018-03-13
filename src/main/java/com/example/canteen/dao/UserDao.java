package com.example.canteen.dao;

import com.example.canteen.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

    @Select("select * from user where id = #{id} and deleted = 0;")
    List<User> findById(@Param("id") int id);

    @Select("select * from user where username = #{username} and deleted = 0;")
    List<User> findByUsername(@Param("username") String username);

    @Select("select * from user where username = #{username} and password = #{password} and deleted = 0;")
    List<User> findByLogin(@Param("username") String username, @Param("password") String password);
}
