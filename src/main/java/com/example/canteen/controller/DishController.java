package com.example.canteen.controller;

import com.example.canteen.model.Dish;
import com.example.canteen.model.RankingList;
import com.example.canteen.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/dish")
@CrossOrigin(origins = {"*"}, maxAge = 3600)
public class DishController {

    @Autowired
    private DishService dishService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public String processList(@RequestBody Dish dish){
        System.out.println("进入获取菜品列表信息接口");
        return dishService.processList(dish);
    }

    @RequestMapping(value = "/ranking/list", method = RequestMethod.POST)
    @ResponseBody
    public String processRankingList(@RequestBody RankingList rankingList){
        System.out.println("进入获取美食排行榜信息接口");
        return dishService.processRankingList(rankingList);
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public String processSearch(@RequestBody Dish dish){
        System.out.println("进入查询菜品信息接口");
        return dishService.processSearch(dish);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String processSearch(HttpServletRequest request){
        System.out.println("进入添加菜品信息接口");
        return dishService.processCreate(request);
    }
}
