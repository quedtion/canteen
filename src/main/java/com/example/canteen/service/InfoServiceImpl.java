package com.example.canteen.service;

import com.example.canteen.dao.InfoDao;
import com.example.canteen.model.Info;
import com.example.canteen.model.ResultCode;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InfoServiceImpl implements InfoService{

    @Autowired
    private InfoDao infoDao;

    private Gson gson = new Gson();

    @Override
    public String processList() {
        ResultCode<List<Info>> resultCode = new ResultCode<List<Info>>();

        Date date = new Date();
        List<Info> infoList = infoDao.findList(date);

        resultCode.setRs(1);
        resultCode.setValue(infoList);

        return gson.toJson(resultCode);
    }
}
