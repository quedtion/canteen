package com.example.canteen.controller;

import com.example.canteen.model.Address;
import com.example.canteen.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/create", method = {RequestMethod.POST})
    @ResponseBody
    public String processCreate(@RequestBody Address address){
        System.out.println("进入添加用户地址接口");
        return addressService.processCreate(address);
    }

    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    @ResponseBody
    public String processAddressList(@RequestBody Address address){
        System.out.println("进入获取用户地址列表接口");
        return addressService.processList(address);
    }
}
