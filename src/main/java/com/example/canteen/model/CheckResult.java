package com.example.canteen.model;

public class CheckResult {
    //检查结果
    private int checkCode;
    //操作人员id
    private int operaterId;
    //检查信息
    private String checkMsg;

    public int getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(int checkCode) {
        this.checkCode = checkCode;
    }

    public int getOperaterId() {
        return operaterId;
    }

    public void setOperaterId(int operaterId) {
        this.operaterId = operaterId;
    }

    public String getCheckMsg() {
        return checkMsg;
    }

    public void setCheckMsg(String checkMsg) {
        this.checkMsg = checkMsg;
    }
}
