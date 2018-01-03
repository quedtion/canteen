package com.example.canteen.mapper;

import com.example.canteen.model.Canteen;
import com.example.canteen.model.CanteenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CanteenMapper {
    long countByExample(CanteenExample example);

    int deleteByExample(CanteenExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Canteen record);

    int insertSelective(Canteen record);

    List<Canteen> selectByExample(CanteenExample example);

    Canteen selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Canteen record, @Param("example") CanteenExample example);

    int updateByExample(@Param("record") Canteen record, @Param("example") CanteenExample example);

    int updateByPrimaryKeySelective(Canteen record);

    int updateByPrimaryKey(Canteen record);
}