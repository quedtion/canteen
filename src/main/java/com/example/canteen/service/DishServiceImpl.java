package com.example.canteen.service;

import com.example.canteen.dao.DishDao;
import com.example.canteen.model.Dish;
import com.example.canteen.model.RankingList;
import com.example.canteen.model.ResultCode;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService{

    private Gson gson = new Gson();

    @Autowired
    private DishDao dishDao;

    @Override
    public String processList(Dish dish) {
        ResultCode<List<Dish>> resultCode = new ResultCode<>();
        do{
            //校验数据
            Integer canteenId = dish.getCanteenid();
            if(canteenId == null){
                resultCode.setRs(-200);
                resultCode.setMsg("传入的id为空");
                break;
            }

            //根据食堂信息id查询菜品信息列表
            try {
                List<Dish> list = dishDao.findListByCanteenId(canteenId);
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

    @Override
    public String processRankingList(RankingList rankingList) {
        ResultCode<List<Dish>> resultCode = new ResultCode<>();
        do{

            try {


//                //设置分页
//                PageHelper.startPage(rankingList.getPage(), rankingList.getAccount());
//
//                PageHelper.orderBy(" salesVolume desc");
                //获取列表
                System.out.println("count = " + rankingList.getAccount());
                List<Dish> list = dishDao.findRankingList(rankingList.getAccount());
                resultCode.setRs(1);
                resultCode.setValue(list);
            } catch (Exception e) {
                e.printStackTrace();
                resultCode.setRs(-350);
                resultCode.setMsg("数据库插入操作错误");
            }
        }while(false);

        return gson.toJson(resultCode);
    }
}
