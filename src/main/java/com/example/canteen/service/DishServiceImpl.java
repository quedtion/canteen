package com.example.canteen.service;

import com.example.canteen.dao.DishDao;
import com.example.canteen.mapper.DishMapper;
import com.example.canteen.model.Dish;
import com.example.canteen.model.RankingList;
import com.example.canteen.model.ResultCode;
import com.example.canteen.utils.Common;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.util.Date;
import java.util.List;

@Service
public class DishServiceImpl implements DishService{

    private Gson gson = new Gson();

    @Autowired
    private DishDao dishDao;

    @Autowired
    private DishMapper dishMapper;

    private Common common = new Common();

    private String fileLocation = "D:/file/";

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

        System.out.println(gson.toJson(resultCode));

        return gson.toJson(resultCode);
    }

    @Override
    public String processSearch(Dish dish) {
        ResultCode<List<Dish>> resultCode = new ResultCode<>();
        do{
            try {
                String name = dish.getName();
                name = "%" + name + "%";
                List<Dish> dishList = dishDao.findByNameLike(name);
                resultCode.setRs(1);
                resultCode.setValue(dishList);
            } catch (Exception e) {
                e.printStackTrace();

            }
        }while(false);

        System.out.println(gson.toJson(resultCode));

        return gson.toJson(resultCode);
    }

    @Override
    public String processCreate(HttpServletRequest request) {
        ResultCode resultCode = new ResultCode();
        try{
            String dishStr = request.getParameter("json");
            Dish dish = gson.fromJson(dishStr, new TypeToken<Dish>(){}.getType());

            Part part = request.getPart("file");
            String url = common.uploadFile(fileLocation, part);

            dish.setPhoto(url);
            dish.setCreatetime(new Date());
            dish.setSalesvolume(0);
            dish.setDeleted(0);

            dishMapper.insertSelective(dish);
            resultCode.setRs(1);

        }catch(Exception e){
            e.printStackTrace();
            resultCode.setRs(-350);
            resultCode.setMsg("数据插入失败");
        }

        return gson.toJson(resultCode);
    }
}
