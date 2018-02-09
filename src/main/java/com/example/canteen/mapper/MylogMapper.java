package com.example.canteen.mapper;

import com.example.canteen.model.Mylog;
import com.example.canteen.model.MylogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MylogMapper {
    long countByExample(MylogExample example);

    int deleteByExample(MylogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Mylog record);

    int insertSelective(Mylog record);

    List<Mylog> selectByExampleWithBLOBs(MylogExample example);

    List<Mylog> selectByExample(MylogExample example);

    Mylog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Mylog record, @Param("example") MylogExample example);

    int updateByExampleWithBLOBs(@Param("record") Mylog record, @Param("example") MylogExample example);

    int updateByExample(@Param("record") Mylog record, @Param("example") MylogExample example);

    int updateByPrimaryKeySelective(Mylog record);

    int updateByPrimaryKeyWithBLOBs(Mylog record);

    int updateByPrimaryKey(Mylog record);
}