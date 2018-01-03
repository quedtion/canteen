package com.example.canteen.model;


public class ResultCode<T> {
    //结果码
    private int rs;
    //错误信息
    private String msg;
    //结果数据
    private T value;

    public int getRs() {
        return rs;
    }

    public void setRs(int rs) {
        this.rs = rs;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
