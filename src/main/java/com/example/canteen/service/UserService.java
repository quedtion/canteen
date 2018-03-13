package com.example.canteen.service;

import com.example.canteen.model.User;

public interface UserService {

    String processRegister(User user);

    String processLogin(User user);
}
