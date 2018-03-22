package com.example.canteen.controller;

import com.example.canteen.model.Dish;
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
    public String processPay(@RequestBody List<Dish> dishList){
        System.out.println("进入下单接口");
        return orderService.processPay(dishList);
    }
}


