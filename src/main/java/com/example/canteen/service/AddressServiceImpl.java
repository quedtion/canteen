package com.example.canteen.service;

import com.example.canteen.dao.AddressDao;
import com.example.canteen.dao.UserDao;
import com.example.canteen.mapper.AddressMapper;
import com.example.canteen.model.*;
import com.example.canteen.utils.ValidationUtils;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private Gson gson = new Gson();
    private ValidationUtils validationUtils = new ValidationUtils();
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private UserDao userDao;

    @Override
    public String processCreate(Address address) {
        ResultCode<Address> resultCode = new ResultCode<>();
        CheckResult checkResult = new CheckResult();
        checkResult.setCheckCode(1);
        do {
            //校验数据
            processValidation(address, checkResult, true);
            if (checkResult.getCheckCode() < 0) {
                break;
            }

            //数据库校验
            checkUser(checkResult, address.getUserid());
            if(checkResult.getCheckCode() < 0){
                break;
            }

            //数据库插入操作
            try {
                addressMapper.insertSelective(address);
                resultCode.setRs(1);
                resultCode.setValue(address);
            } catch (Exception e) {
                e.printStackTrace();
                checkResult.setCheckCode(-350);
                checkResult.setCheckMsg("数据库插入操作错误");
            }

        }while(false);
        if (checkResult.getCheckCode() < 0) {
            resultCode.setRs(checkResult.getCheckCode());
            resultCode.setMsg(checkResult.getCheckMsg());
        }

        return gson.toJson(resultCode);
    }

    @Override
    public String processList(Address address) {
        ResultCode<List<Address>> resultCode = new ResultCode<>();
        CheckResult checkResult = new CheckResult();
        checkResult.setCheckCode(1);
        do {
            //校验数据
            processValidation(address, checkResult, true);
            if (checkResult.getCheckCode() < 0) {
                break;
            }

            //数据库查询操作
            try {
                List<Address> list = new ArrayList<>();
                list = addressDao.findList(address.getUserid());
                resultCode.setRs(1);
                resultCode.setValue(list);
            } catch (Exception e) {
                e.printStackTrace();
                checkResult.setCheckCode(-350);
                checkResult.setCheckMsg("数据库插入操作错误");
            }

        }while(false);
        if (checkResult.getCheckCode() < 0) {
            resultCode.setRs(checkResult.getCheckCode());
            resultCode.setMsg(checkResult.getCheckMsg());
        }

        return gson.toJson(resultCode);
    }

    /**
     * 校验传入的食堂数据是否正确
     * @param address 食堂信息model
     * @param checkResult 校验结果model
     * @param withoutId  true不需要校验id/false需要校验id
     */
    private void processValidation(Address address, CheckResult checkResult, boolean withoutId) {
        List<Validation> validations = new ArrayList<>();

        validationUtils.verifyString("主键", address.getId(), "number", 1,
                10, withoutId, validations);

        validationUtils.verifyString("用户id", address.getUserid(), "number", 1,
                10, false, validations);

        if (!validations.isEmpty()) {
            checkResult.setCheckCode(validations.get(0).getCode());
            checkResult.setCheckCode(validations.get(0).getCode());
            checkResult.setCheckMsg(validations.get(0).getField() + validations.get(0).getError());
        }
    }

    private void checkUser(CheckResult checkResult, int userId){

        List<User> list = userDao.findById(userId);
        if(list.isEmpty()){
            checkResult.setCheckCode(-340);
            checkResult.setCheckMsg("用户不存在");
        }else if(list.size() > 1){
            checkResult.setCheckCode(-340);
            checkResult.setCheckMsg("传入的用户id有误");
        }
    }
}
