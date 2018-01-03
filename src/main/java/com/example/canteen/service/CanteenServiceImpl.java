package com.example.canteen.service;

import com.example.canteen.dao.CanteenDao;
import com.example.canteen.model.Canteen;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CanteenServiceImpl implements CanteenService {

    @Autowired
    private CanteenDao canteenDao;

    private Gson gson = new Gson();

    @Override
    public String processList() {
        List<Canteen> list = canteenDao.findList();
        return gson.toJson(list);
    }
}
