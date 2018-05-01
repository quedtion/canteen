package com.example.canteen.service;

import com.example.canteen.model.Dish;
import com.example.canteen.model.RankingList;

import javax.servlet.http.HttpServletRequest;

public interface DishService {
    /**
     * 根据食堂id获取菜品列表
     * @param dish
     * @return
     */
    String processList(Dish dish);

    /**
     * 获取美食排行榜
     * @param rankingList 分页信息
     * @return
     */
    String processRankingList(RankingList rankingList);

    String processSearch(Dish dish);

    String processCreate(HttpServletRequest request);
}
