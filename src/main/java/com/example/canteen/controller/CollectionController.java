package com.example.canteen.controller;

import com.example.canteen.model.Mycollection;
import com.example.canteen.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/collection")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String processCreate(@RequestBody Mycollection mycollection){

        System.out.println("进入添加收藏接口");
        return collectionService.processCreate(mycollection);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String processUpdate(@RequestBody Mycollection mycollection){

        System.out.println("进入修改收藏接口");
        return collectionService.processUpdate(mycollection);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public String processList(@RequestBody Mycollection mycollection){

        System.out.println("进入查询收藏列表接口");
        return collectionService.processList(mycollection);
    }
}
