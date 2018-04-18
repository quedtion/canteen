package com.example.canteen.service;

import com.example.canteen.dao.CanteenDao;
import com.example.canteen.mapper.CanteenMapper;
import com.example.canteen.model.Canteen;
import com.example.canteen.model.CheckResult;
import com.example.canteen.model.ResultCode;
import com.example.canteen.model.Validation;
import com.example.canteen.utils.Common;
import com.example.canteen.utils.ValidationUtils;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CanteenServiceImpl implements CanteenService {

    @Autowired
    private CanteenDao canteenDao;
    @Autowired
    private CanteenMapper canteenMapper;

    private Gson gson = new Gson();
    private Common<Canteen> common = new Common();
    private ValidationUtils validationUtils = new ValidationUtils();

    @Override
    public String processList() {
        ResultCode<List<Canteen>> resultCode = new ResultCode<>();

        try {
            List<Canteen> list = canteenDao.findList();
            common.validateList(resultCode, list);
        } catch (Exception e) {
            e.printStackTrace();
            resultCode.setRs(-350);
            resultCode.setMsg("数据库插入操作错误");
        }
        return gson.toJson(resultCode);
    }

    @Override
    public String processCreate(Canteen canteen, HttpServletRequest request) {
        ResultCode<Canteen> resultCode = new ResultCode<>();
        CheckResult checkResult = new CheckResult();
        checkResult.setCheckCode(1);
        do{
            //校验数据
            processValidation(canteen, checkResult, true);
            if(checkResult.getCheckCode() < 0){
                break;
            }

            //存储图片

            //插入操作之前校验数据库
            processDB(canteen, checkResult, true);
            if(checkResult.getCheckCode() < 0){
                break;
            }

            //数据库插入操作
            try {
                Date date = new Date();
                canteen.setCreatetime(date);
                canteen.setDeleted(0);

                canteenMapper.insertSelective(canteen);
                resultCode.setRs(1);
                resultCode.setValue(canteen);
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
    public String processUpdate(Canteen canteen, HttpServletRequest request) {
        ResultCode<Canteen> resultCode = new ResultCode<>();
        CheckResult checkResult = new CheckResult();
        checkResult.setCheckCode(1);
        do{
            //校验数据
            processValidation(canteen, checkResult, false);
            if(checkResult.getCheckCode() < 0){
                break;
            }

            //存储图片

            //插入操作之前校验数据库
            processDB(canteen, checkResult, false);
            if(checkResult.getCheckCode() < 0){
                break;
            }

            Canteen oldCanteen = canteenDao.findById(canteen.getId());
            if(oldCanteen == null){
                checkResult.setCheckCode(-340);
                checkResult.setCheckMsg("传入的id有误");
                break;
            }
            //数据库操作操作
            try {
                canteen.setDeleted(0);
                canteen.setCreatetime(oldCanteen.getCreatetime());
                canteenMapper.updateByPrimaryKeySelective(canteen);
                resultCode.setRs(1);
                resultCode.setValue(canteen);
            } catch (Exception e) {
                e.printStackTrace();
                checkResult.setCheckCode(-350);
                checkResult.setCheckMsg("数据库更新操作错误");
            }

        }while(false);
        if (checkResult.getCheckCode() < 0) {
            resultCode.setRs(checkResult.getCheckCode());
            resultCode.setMsg(checkResult.getCheckMsg());
        }

        return gson.toJson(resultCode);
    }

    @Override
    public String processDelete(Canteen canteen) {
        ResultCode resultCode = new ResultCode();
        CheckResult checkResult = new CheckResult();
        checkResult.setCheckCode(1);
        do{
            //校验数据
            Integer id = canteen.getId();
            if(id == null){
                checkResult.setCheckCode(-200);
                checkResult.setCheckMsg("传入的id为空");
                break;
            }

            //逻辑删除之前校验数据库
            canteen = canteenDao.findById(canteen.getId());
            if(canteen == null){
                checkResult.setCheckCode(-340);
                checkResult.setCheckMsg("传入的id有误");
                break;
            }

            //逻辑删除操作
            try {
                canteen.setDeleted(1);
                resultCode.setRs(1);
            } catch (Exception e) {
                e.printStackTrace();
                checkResult.setCheckCode(-350);
                checkResult.setCheckMsg("数据库更新操作错误");
            }
        }while(false);
        if (checkResult.getCheckCode() < 0) {
            resultCode.setRs(checkResult.getCheckCode());
            resultCode.setMsg(checkResult.getCheckMsg());
        }

        return gson.toJson(resultCode);
    }

    @Override
    public String processListHallId(Canteen canteen) {

        ResultCode<List<Canteen>> resultCode = new ResultCode<>();

        Integer hallId = canteen.getHallid();
        if(hallId == null){
            resultCode.setRs(-200);
            resultCode.setMsg("传入的id为空");
            return gson.toJson(resultCode);
        }

        try {
            List<Canteen> list = canteenDao.findListHallId(hallId);
            resultCode.setRs(1);
            resultCode.setValue(list);
        } catch (Exception e) {
            e.printStackTrace();
            resultCode.setRs(-350);
            resultCode.setMsg("数据库插入操作错误");
        }
        System.out.println(gson.toJson(resultCode));
        return gson.toJson(resultCode);

    }


    /**
     * 校验传入的食堂数据是否正确
     * @param canteen 食堂信息model
     * @param checkResult 校验结果model
     * @param withoutId  true不需要校验id/false需要校验id
     */
    private void processValidation(Canteen canteen, CheckResult checkResult, boolean withoutId) {
        List<Validation> validations = new ArrayList<>();

        validationUtils.verifyString("食堂名称", canteen.getName(), "chinese", 3, 10,
                false, validations);

        validationUtils.verifyString("地址", canteen.getAddress(), "validation", 1,
                100, true, validations);

        validationUtils.verifyString("主键", canteen.getId(), "number", 1,
                10, withoutId, validations);

        if (!validations.isEmpty()) {
            checkResult.setCheckCode(validations.get(0).getCode());
            checkResult.setCheckCode(validations.get(0).getCode());
            checkResult.setCheckMsg(validations.get(0).getField() + validations.get(0).getError());
        }
    }

    /**
     * 检测是否可以进行插入或修改操作
     * @param canteen 食堂信息model
     * @param checkResult 校验结果
     * @param isCreate true创建时校验/false修改时校验
     */
    private void processDB(Canteen canteen, CheckResult checkResult, boolean isCreate){
        try {
            List<Canteen> list = new ArrayList<>();
            if(isCreate){
                list = canteenDao.findByName(canteen.getName());
                if(!list.isEmpty()){
                    checkResult.setCheckCode(-310);
                    checkResult.setCheckMsg("食堂名称已存在");
                }
                return;
            }
            if(canteenDao.findById(canteen.getId()) != null){
                list = canteenDao.findByIdOrName(canteen.getName(), canteen.getId());
                if(list.size() > 1){
                    checkResult.setCheckCode(-310);
                    checkResult.setCheckMsg("食堂名称已存在");
                }
            }else{
                checkResult.setCheckCode(-340);
                checkResult.setCheckMsg("传入的id有误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            checkResult.setCheckCode(-320);
            checkResult.setCheckMsg("数据库错误");
        }
    }
}
