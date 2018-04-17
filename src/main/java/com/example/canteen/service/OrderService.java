package com.example.canteen.service;

import com.example.canteen.model.Orders;


public interface OrderService {

    String processPay(Orders orders);

    String processList(Orders orders);

    String processDetail(Orders orders);
}
