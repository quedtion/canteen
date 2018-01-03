package com.example.canteen.controller;

import com.example.canteen.service.CanteenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/canteen")
@CrossOrigin(value = "*", maxAge = 3600)
public class CanteenController {

    @Autowired
    private CanteenService canteenService;

    @RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String processList(){
        return canteenService.processList();
    }

}
