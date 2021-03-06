package com.example.canteen.dao;

import com.example.canteen.model.Usercontent;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UsercontentDao {

    /**
     * 根据食堂id获取评论列表
     * @param canteenId 食堂id
     * @return
     */
    @Select("select * from userContent where canteenId = #{canteenId};")
    List<Usercontent> findListByCanteenId(@Param("canteenId") int canteenId);

    /**
     * 根据订单id获取评论列表
     * @param code  订单号
     * @return
     */
    @Select("select * from userContent where code = #{code};")
    List<Usercontent> findListByCode(@Param("code") String code);


}
