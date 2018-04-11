package com.example.canteen.service;

import com.example.canteen.model.Discount;

public interface DiscountService {

    /**
     * 根据id获取打折信息详情
     * @param discount
     * @return
     */
    String processDetail(Discount discount);
}
