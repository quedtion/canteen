package com.example.canteen.controller;

import com.example.canteen.model.Dish;
import com.example.canteen.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dish")
public class DishController {

    @Autowired
    private DishService dishService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public String processList(@RequestBody Dish dish){
        System.out.println("进入获取菜品列表信息接口");
        return dishService.processList(dish);
    }

}
