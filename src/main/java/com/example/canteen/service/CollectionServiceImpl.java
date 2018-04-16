package com.example.canteen.service;

import com.example.canteen.dao.CollectionDao;
import com.example.canteen.mapper.MycollectionMapper;
import com.example.canteen.model.Mycollection;
import com.example.canteen.model.ResultCode;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionServiceImpl implements  CollectionService {

    private Gson gson = new Gson();

    @Autowired
    private CollectionDao collectionDao;

    @Autowired
    private MycollectionMapper mycollectionMapper;

    @Override
    public String processCreate(Mycollection mycollection) {
        ResultCode<Mycollection> resultCode = new ResultCode<>();
        do{

            try {
                mycollectionMapper.insertSelective(mycollection);
                resultCode.setRs(1);
                resultCode.setValue(mycollection);
            } catch (Exception e) {
                e.printStackTrace();
                resultCode.setRs(-350);
                resultCode.setMsg("数据库插入操作错误");
            }
        }while(false);

        return gson.toJson(resultCode);
    }

    @Override
    public String processUpdate(Mycollection mycollection) {
        ResultCode<Mycollection> resultCode = new ResultCode<>();
        do{

            try {
                mycollectionMapper.updateByPrimaryKeySelective(mycollection);
                resultCode.setRs(1);
                resultCode.setValue(mycollection);
            } catch (Exception e) {
                e.printStackTrace();
                resultCode.setRs(-350);
                resultCode.setMsg("数据库更新操作错误");
            }
        }while(false);

        return gson.toJson(resultCode);
    }

    @Override
    public String processList(Mycollection mycollection) {
        ResultCode<List<Mycollection>> resultCode = new ResultCode<>();
        do{
            //校验数据
            Integer userId = mycollection.getUserid();
            if(userId == null){
                resultCode.setRs(-200);
                resultCode.setMsg("传入的id为空");
                break;
            }
            try {
                List<Mycollection> list = collectionDao.findList(userId);
                if(!list.isEmpty()){
                    resultCode.setRs(1);
                    resultCode.setValue(list);
                }else{
                    resultCode.setRs(-300);
                    resultCode.setMsg("无数据");
                }
            } catch (Exception e) {
                e.printStackTrace();
                resultCode.setRs(-350);
                resultCode.setMsg("数据库插入操作错误");
            }
        }while(false);

        return gson.toJson(resultCode);

    }
}
