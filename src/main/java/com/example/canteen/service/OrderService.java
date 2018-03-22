package com.example.canteen.service;

import com.example.canteen.model.Dish;

import java.util.List;

public interface OrderService {

    public String processPay(List<Dish> dishList);
}
