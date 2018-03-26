package com.example.canteen.model;

import java.util.Date;
import java.util.List;

public class Orders {
    private String code;

    private Integer userid;

    private String canteenname;

    private Integer canteenid;

    private Date createtime;

    private Integer status;

    private Double shouldpay;

    private String address;

    private String remark;

    private List<Dish> dishList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getCanteenname() {
        return canteenname;
    }

    public void setCanteenname(String canteenname) {
        this.canteenname = canteenname == null ? null : canteenname.trim();
    }

    public Integer getCanteenid() {
        return canteenid;
    }

    public void setCanteenid(Integer canteenid) {
        this.canteenid = canteenid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getShouldpay() {
        return shouldpay;
    }

    public void setShouldpay(Double shouldpay) {
        this.shouldpay = shouldpay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }
}