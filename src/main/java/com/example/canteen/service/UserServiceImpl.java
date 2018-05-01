package com.example.canteen.service;

import com.example.canteen.dao.UserDao;
import com.example.canteen.mapper.UserMapper;
import com.example.canteen.model.CheckResult;
import com.example.canteen.model.ResultCode;
import com.example.canteen.model.User;
import com.example.canteen.model.Validation;
import com.example.canteen.utils.ValidationUtils;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserMapper userMapper;

    private Gson gson = new Gson();
    private ValidationUtils validationUtils = new ValidationUtils();

    @Override
    public String processRegister(User user) {
        ResultCode<User> resultCode = new ResultCode<>();
        CheckResult checkResult = new CheckResult();
        checkResult.setCheckCode(1);
        do{
            //校验数据
            processValidation(user, checkResult, true);
            if(checkResult.getCheckCode() < 0){
                break;
            }

            //插入操作之前校验数据库
            processDB(user, checkResult);
            if(checkResult.getCheckCode() < 0){
                break;
            }

            //数据库插入操作
            try {
                user.setDeleted(0);
                userMapper.insertSelective(user);
                resultCode.setRs(1);
                resultCode.setValue(user);
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
    public String processLogin(User user) {
        ResultCode<User> resultCode = new ResultCode<>();
        CheckResult checkResult = new CheckResult();
        checkResult.setCheckCode(1);
        do{
            //校验数据
            processValidation(user, checkResult, true);
            if(checkResult.getCheckCode() < 0){
                break;
            }

            List<User> list = userDao.findByLogin(user.getUsername(), user.getPassword());
            if(list.size() != 1){
                checkResult.setCheckCode(-1);
                checkResult.setCheckMsg("用户名或密码错误");
                break;
            }
            resultCode.setRs(1);
            resultCode.setValue(list.get(0));

        }while(false);
        if (checkResult.getCheckCode() < 0) {
            resultCode.setRs(checkResult.getCheckCode());
            resultCode.setMsg(checkResult.getCheckMsg());
        }
        return gson.toJson(resultCode);
    }


    /**
     * 校验传入的用户数据是否正确
     * @param user 用户信息model
     * @param checkResult 校验结果model
     * @param withoutId  true不需要校验id/false需要校验id
     */
    private void processValidation(User user, CheckResult checkResult, boolean withoutId) {
        List<Validation> validations = new ArrayList<>();

        validationUtils.verifyString("用户名", user.getUsername(), "letters.number", 2, 10,
                false, validations);

        validationUtils.verifyString("密码", user.getPassword(), "letters.number", 1,
                10, false, validations);

        validationUtils.verifyString("姓名", user.getName(), "chinese", 2,
                4, withoutId, validations);

        if (!validations.isEmpty()) {
            checkResult.setCheckCode(validations.get(0).getCode());
            checkResult.setCheckCode(validations.get(0).getCode());
            checkResult.setCheckMsg(validations.get(0).getField() + validations.get(0).getError());
        }
    }

    /**
     * 校验用户名是否存在
     * @param user 用户信息
     * @param checkResult 校验结果
     */
    private void processDB(User user, CheckResult checkResult) {
        String username = user.getUsername();
        List<User> list = userDao.findByUsername(username);
        if(list.size() != 0){
            checkResult.setCheckCode(-1);
            checkResult.setCheckMsg("该用户已存在");
        }
    }
}
