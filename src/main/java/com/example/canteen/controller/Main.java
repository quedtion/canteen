package com.example.canteen.controller;

import com.example.canteen.model.Dish;
import com.example.canteen.model.Orders;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Orders orders = new Orders();
        orders.setCanteenid(1);
        List<Dish> list = new ArrayList<>();
        Dish dish = new Dish();
        dish.setCanteenid(1);
        dish.setName("hhh");
        dish.setNum(4);
        dish.setPrice(12.5);
        dish.setId(1);
        list.add(dish);
        orders.setDishList(list);

        Gson gson = new Gson();
        System.out.println(gson.toJson(orders));
    }
}
