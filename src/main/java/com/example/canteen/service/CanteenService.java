package com.example.canteen.service;

import com.example.canteen.model.Canteen;

import javax.servlet.http.HttpServletRequest;

public interface CanteenService {

    /**
     * 获取食堂信息列表
     * @return
     */
    String processList();

    /**
     * 新增食堂信息
     * @param request 网络请求
     * @return 结果信息json
     */
    String processCreate(HttpServletRequest request);

    /**
     * 修改食堂信息
     * @param canteen 食堂信息model
     * @param request 网络请求
     * @return 结果信息json
     */
    String processUpdate(Canteen canteen, HttpServletRequest request);

    /**
     * 逻辑删除食堂信息
     * @param canteen 食堂信息model
     * @return 结果信息json
     */
    String processDelete(Canteen canteen);

    String processListHallId(Canteen canteen);
}
