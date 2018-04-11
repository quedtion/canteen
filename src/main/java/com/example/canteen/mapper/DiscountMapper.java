package com.example.canteen.mapper;

import com.example.canteen.model.Discount;
import com.example.canteen.model.DiscountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DiscountMapper {
    long countByExample(DiscountExample example);

    int deleteByExample(DiscountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Discount record);

    int insertSelective(Discount record);

    List<Discount> selectByExampleWithBLOBs(DiscountExample example);

    List<Discount> selectByExample(DiscountExample example);

    Discount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Discount record, @Param("example") DiscountExample example);

    int updateByExampleWithBLOBs(@Param("record") Discount record, @Param("example") DiscountExample example);

    int updateByExample(@Param("record") Discount record, @Param("example") DiscountExample example);

    int updateByPrimaryKeySelective(Discount record);

    int updateByPrimaryKeyWithBLOBs(Discount record);

    int updateByPrimaryKey(Discount record);
}