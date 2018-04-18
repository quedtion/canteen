package com.example.canteen.controller;

import com.example.canteen.model.Usercontent;
import com.example.canteen.service.UserContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private UserContentService userContentService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String processCreate(@RequestBody Usercontent usercontent){
        System.out.println("进入评论接口");
        return userContentService.processCreate(usercontent);
    }

    @RequestMapping(value = "/listByCanteen", method = RequestMethod.POST)
    @ResponseBody
    public String processListByCanteenId(@RequestBody Usercontent usercontent){
        System.out.println("进入根据商家id获取评论列表接口");
        return userContentService.processListByCanteenId(usercontent);
    }

    @RequestMapping(value = "/listByOrder", method = RequestMethod.POST)
    @ResponseBody
    public String processListByOrderId(@RequestBody Usercontent usercontent){
        System.out.println("进入根据订单号获取评论列表接口");
        return userContentService.processListByCode(usercontent);
    }
}
