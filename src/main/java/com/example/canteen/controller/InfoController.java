package com.example.canteen.controller;

import com.example.canteen.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/info")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    String processList(){
        System.out.println("获取评论列表接口");
        return infoService.processList();
    }
}
