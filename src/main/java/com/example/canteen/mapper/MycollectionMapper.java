package com.example.canteen.mapper;

import com.example.canteen.model.Mycollection;
import com.example.canteen.model.MycollectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MycollectionMapper {
    long countByExample(MycollectionExample example);

    int deleteByExample(MycollectionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Mycollection record);

    int insertSelective(Mycollection record);

    List<Mycollection> selectByExample(MycollectionExample example);

    Mycollection selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Mycollection record, @Param("example") MycollectionExample example);

    int updateByExample(@Param("record") Mycollection record, @Param("example") MycollectionExample example);

    int updateByPrimaryKeySelective(Mycollection record);

    int updateByPrimaryKey(Mycollection record);
}