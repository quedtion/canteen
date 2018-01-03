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
        System.out.println("进入获取食堂信息列表接口");
        return canteenService.processList();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String processCreate(@RequestBody Canteen canteen, HttpServletRequest request){
        System.out.println("进入新增食堂信息接口");
        return canteenService.processCreate(canteen, request);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String processUpdate(@RequestBody Canteen canteen, HttpServletRequest request){
        System.out.println("进入修改食堂信息接口");
        return canteenService.processUpdate(canteen, request);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public String processDelete(Canteen canteen){
        System.out.println("进入删除食堂信息列表接口");
        return canteenService.processDelete(canteen);
    }
}
