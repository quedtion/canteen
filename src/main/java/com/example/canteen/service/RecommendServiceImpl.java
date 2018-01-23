package com.example.canteen.service;

import com.example.canteen.dao.RecommendDao;
import com.example.canteen.model.Recommend;
import com.example.canteen.model.ResultCode;
import com.example.canteen.utils.Common;
import com.example.canteen.utils.ValidationUtils;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendServiceImpl implements  RecommendService {

    @Autowired
    private RecommendDao recommendDao;

    private Gson gson = new Gson();
    private Common<Recommend> common = new Common();
    private ValidationUtils validationUtils = new ValidationUtils();

    @Override
    public String processList() {
        ResultCode<List<Recommend>> resultCode = new ResultCode<>();
        try {
            List<Recommend> list = recommendDao.findList();
            common.validateList(resultCode, list);
        } catch (Exception e) {
            e.printStackTrace();
            resultCode.setRs(-350);
            resultCode.setMsg("数据库插入操作错误");
        }
        return gson.toJson(resultCode);
    }
}
