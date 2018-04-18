package com.example.canteen.controller;

import com.example.canteen.model.Canteen;
import com.example.canteen.service.CanteenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/canteen")
@CrossOrigin(value = "*", maxAge = 3600)
public class CanteenController {

    @Autowired
    private CanteenService canteenService;

    @RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String processList(){
        System.out.println("进入获取商家信息列表接口");
        return canteenService.processList();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String processCreate(@RequestBody Canteen canteen, HttpServletRequest request){
        System.out.println("进入新增商家信息接口");
        return canteenService.processCreate(canteen, request);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String processUpdate(@RequestBody Canteen canteen, HttpServletRequest request){
        System.out.println("进入修改商家信息接口");
        return canteenService.processUpdate(canteen, request);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public String processDelete(Canteen canteen){
        System.out.println("进入删除商家信息列表接口");
        return canteenService.processDelete(canteen);
    }

    @RequestMapping(value = "/listByHallId", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String processListHallId(@RequestBody Canteen canteen){
        System.out.println("进入根据食堂id获取商家信息列表接口");
        return canteenService.processListHallId(canteen);
    }
}
