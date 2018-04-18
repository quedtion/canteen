package com.example.canteen.dao;

import com.example.canteen.model.Info;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface InfoDao {

    @Select("select A.*, B.name canteenname, B.photo canteenphoto from info A INNER JOIN canteen B" +
            " on A.canteenId = B.id and A.validTime > #{date};")
    List<Info> findList(@Param("date") Date date);
}
