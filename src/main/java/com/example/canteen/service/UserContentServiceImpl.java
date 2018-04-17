package com.example.canteen.service;

import com.example.canteen.dao.UsercontentDao;
import com.example.canteen.mapper.UsercontentMapper;
import com.example.canteen.model.CheckResult;
import com.example.canteen.model.ResultCode;
import com.example.canteen.model.Usercontent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserContentServiceImpl implements UserContentService{

    @Autowired
    private UsercontentMapper usercontentMapper;

    @Autowired
    private UsercontentDao usercontentDao;

    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    @Override
    public String processCreate(Usercontent usercontent) {
        ResultCode<List<Usercontent>> resultCode = new ResultCode<>();
        CheckResult checkResult = new CheckResult();
        checkResult.setCheckCode(1);
        do {
            try{
                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                usercontent.setCreatetime(dateFormat.format(date));
                usercontentMapper.insertSelective(usercontent);
                List<Usercontent> usercontentList = new ArrayList<>();
                usercontentList.add(usercontent);
                resultCode.setRs(1);
                resultCode.setValue(usercontentList);
            }catch(Exception e){
                e.printStackTrace();
                checkResult.setCheckCode(-350);
                checkResult.setCheckMsg("数据库插入操作错误");
            }
        }
        while(false);
        if (checkResult.getCheckCode() < 0) {
            resultCode.setRs(checkResult.getCheckCode());
            resultCode.setMsg(checkResult.getCheckMsg());
        }
        return gson.toJson(resultCode);
    }

    @Override
    public String processListByCanteenId(Usercontent usercontent) {
        ResultCode<List<Usercontent>> resultCode = new ResultCode<>();
        CheckResult checkResult = new CheckResult();
        checkResult.setCheckCode(1);
        do {
            try{
                //根据食堂id获取评论列表
                List<Usercontent> userContentList = usercontentDao.findListByCanteenId(usercontent.getCanteenid());
                resultCode.setRs(1);
                resultCode.setValue(userContentList);
            }catch(Exception e){
                e.printStackTrace();
                checkResult.setCheckCode(-350);
                checkResult.setCheckMsg("数据库插入操作错误");
            }
        }
        while(false);
        if (checkResult.getCheckCode() < 0) {
            resultCode.setRs(checkResult.getCheckCode());
            resultCode.setMsg(checkResult.getCheckMsg());
        }
        return gson.toJson(resultCode);
    }

    @Override
    public String processListByCode(Usercontent usercontent) {
        ResultCode<List<Usercontent>> resultCode = new ResultCode<>();
        CheckResult checkResult = new CheckResult();
        checkResult.setCheckCode(1);
        do {
            try{
                //根据订单id获取评论列表
                List<Usercontent> userContentList = usercontentDao.findListByCode(usercontent.getCode());
                if(userContentList.size() > 0){
                    resultCode.setRs(1);
                    resultCode.setValue(userContentList);
                }else{
                    resultCode.setRs(-300);
                    resultCode.setMsg("无数据");
                }

            }catch(Exception e){
                e.printStackTrace();
                checkResult.setCheckCode(-350);
                checkResult.setCheckMsg("数据库查询操作错误");
            }
        }
        while(false);
        if (checkResult.getCheckCode() < 0) {
            resultCode.setRs(checkResult.getCheckCode());
            resultCode.setMsg(checkResult.getCheckMsg());
        }
        return gson.toJson(resultCode);
    }


}
