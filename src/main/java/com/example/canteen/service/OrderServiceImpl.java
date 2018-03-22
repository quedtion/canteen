package com.example.canteen.service;

import com.example.canteen.dao.CanteenDao;
import com.example.canteen.mapper.OrderDetailMapper;
import com.example.canteen.mapper.OrdersMapper;
import com.example.canteen.model.*;
import com.example.canteen.utils.Common;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CanteenDao canteenDao;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    private Gson gson = new Gson();
    private Common common = new Common<>();

    @Override
    public String processPay(List<Dish> dishList) {
        ResultCode<Orders> resultCode = new ResultCode<>();
        CheckResult checkResult = new CheckResult();
        checkResult.setCheckCode(1);
        Orders orders = new Orders();
        OrderDetail orderDetail =  new OrderDetail();
        String uuid = common.generateUUID();
        double shouldPay = 0.0;
        orders.setCode(uuid);
        Date date = new Date();
        do{
            for(int i = 0; i < dishList.size(); i ++){
                Dish dish = dishList.get(i);
                orderDetail.setCode(uuid);
                orderDetail.setCount(dish.getNum());
                orderDetail.setDishid(dish.getId());
                orderDetail.setPrice(dish.getPrice());
                orderDetail.setDishname(dish.getName());
                orderDetailMapper.insertSelective(orderDetail);
                shouldPay += dish.getPrice() * dish.getNum();
            }
            int canteenId = dishList.get(0).getCanteenid();
            orders.setCanteenid(canteenId);
            Canteen canteen = canteenDao.findById(canteenId);
            orders.setCanteenname(canteen.getName());
            orders.setCreatetime(date);
            orders.setShouldpay(shouldPay);
            orders.setStatus(1);
            orders.setUserid(1);
            ordersMapper.insertSelective(orders);
            resultCode.setRs(1);
            resultCode.setValue(orders);

        }while(false);
        if (checkResult.getCheckCode() < 0) {
            resultCode.setRs(checkResult.getCheckCode());
            resultCode.setMsg(checkResult.getCheckMsg());
        }
        return gson.toJson(resultCode);
    }
}
