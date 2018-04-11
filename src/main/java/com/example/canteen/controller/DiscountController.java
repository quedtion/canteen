package com.example.canteen.controller;

import com.example.canteen.model.Discount;
import com.example.canteen.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/discount")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @RequestMapping(value = "discount", method = RequestMethod.POST)
    @ResponseBody
    public String processDetail(@RequestBody Discount discount){

        System.out.println("进入查看打折信息详情接口");
        return discountService.processDetail(discount);
    }
}
