package com.example.canteen.service;

import com.example.canteen.model.Usercontent;

public interface UserContentService {
    //新增评论
    String processCreate(Usercontent usercontent);
    //根据食堂id查询评论
    String processListByCanteenId(Usercontent usercontent);
    //根据订单号查询评论
    String processListByCode(Usercontent usercontent);
}
