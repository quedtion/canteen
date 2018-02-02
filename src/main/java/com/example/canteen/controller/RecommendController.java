package com.example.canteen.controller;

import com.example.canteen.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/recommend")
@CrossOrigin(origins = {"*"}, maxAge = 3600)
public class RecommendController {

    @Autowired
    private RecommendService recommendService;

    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    @ResponseBody
    public String processList(){
        System.out.println("进入获取推荐列表接口");
        return recommendService.processList();
    }

}
