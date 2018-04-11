package com.example.canteen.service;

import com.example.canteen.dao.DiscountDao;
import com.example.canteen.model.CheckResult;
import com.example.canteen.model.Discount;
import com.example.canteen.model.ResultCode;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountServiceImpl implements DiscountService{

    @Autowired
    private DiscountDao discountDao;

    private Gson gson = new Gson();

    @Override
    public String processDetail(Discount discount) {
        ResultCode<Discount> resultCode = new ResultCode<>();
        CheckResult checkResult = new CheckResult();
        checkResult.setCheckCode(1);
        do {
            try{
                discount = discountDao.findById(discount.getId());
                resultCode.setRs(1);
                resultCode.setValue(discount);
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
