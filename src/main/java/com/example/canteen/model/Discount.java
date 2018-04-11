package com.example.canteen.model;

import java.util.Date;

public class Discount {
    private Integer id;

    private Integer canteenid;

    private Date validtime;

    private Integer deleted;

    private String info;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCanteenid() {
        return canteenid;
    }

    public void setCanteenid(Integer canteenid) {
        this.canteenid = canteenid;
    }

    public Date getValidtime() {
        return validtime;
    }

    public void setValidtime(Date validtime) {
        this.validtime = validtime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }
}