package com.example.canteen.dao;

import com.example.canteen.model.Recommend;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RecommendDao {

    @Select("select * from recommend where deleted = 0;")
    List<Recommend> findList();
}
