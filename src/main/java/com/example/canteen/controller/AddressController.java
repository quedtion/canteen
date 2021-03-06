package com.example.canteen.controller;

import com.example.canteen.model.Address;
import com.example.canteen.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/address")
@CrossOrigin(origins = {"*"}, maxAge = 3600)
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
    public String processList(@RequestBody Address address){
        System.out.println("进入获取用户地址列表接口");
        return addressService.processList(address);
    }

    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    @ResponseBody
    public String processUpdate(@RequestBody Address address){
        System.out.println("进入修改用户地址列表接口");
        return addressService.processUpdate(address);
    }
}
