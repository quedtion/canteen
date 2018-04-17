package com.example.canteen.controller;

import com.example.canteen.model.Dish;
import com.example.canteen.model.Orders;
import com.example.canteen.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    @ResponseBody
    public String processPay(@RequestBody Orders orders){
        System.out.println("进入下单接口");
        return orderService.processPay(orders);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public String prcessList(@RequestBody Orders orders){
        System.out.println("进入查询我的订单接口");
        return orderService.processList(orders);
    }
}


