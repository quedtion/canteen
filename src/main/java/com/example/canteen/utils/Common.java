package com.example.canteen.utils;

import com.example.canteen.model.ResultCode;

import java.util.List;

public class Common<T> {

    public void validateList(ResultCode<List<T>> resultCode, List<T> list){
        if(list.isEmpty()){
            resultCode.setRs(-350);
            resultCode.setMsg("数据库插入操作错误");
        }else{
            resultCode.setRs(1);
            resultCode.setValue(list);
        }
    }
}
