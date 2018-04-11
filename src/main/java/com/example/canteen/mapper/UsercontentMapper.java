package com.example.canteen.mapper;

import com.example.canteen.model.Usercontent;
import com.example.canteen.model.UsercontentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsercontentMapper {
    long countByExample(UsercontentExample example);

    int deleteByExample(UsercontentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Usercontent record);

    int insertSelective(Usercontent record);

    List<Usercontent> selectByExampleWithBLOBs(UsercontentExample example);

    List<Usercontent> selectByExample(UsercontentExample example);

    Usercontent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Usercontent record, @Param("example") UsercontentExample example);

    int updateByExampleWithBLOBs(@Param("record") Usercontent record, @Param("example") UsercontentExample example);

    int updateByExample(@Param("record") Usercontent record, @Param("example") UsercontentExample example);

    int updateByPrimaryKeySelective(Usercontent record);

    int updateByPrimaryKeyWithBLOBs(Usercontent record);

    int updateByPrimaryKey(Usercontent record);
}