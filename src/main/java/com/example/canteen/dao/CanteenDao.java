package com.example.canteen.dao;

import com.example.canteen.model.Canteen;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CanteenDao {

    @Select("select * from canteen where deleted = 0;")
    List<Canteen> findList();
}
