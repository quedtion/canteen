package com.example.canteen.controller;

import com.example.canteen.model.User;
import com.example.canteen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@CrossOrigin(origins = {"*"}, maxAge = 3600)
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String processRegister(@RequestBody User user){
        System.out.println("进入注册接口");
        return userService.processRegister(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String processLogin(@RequestBody User user){
        System.out.println("进入登录接口");
        return userService.processLogin(user);
    }
}
