package com.example.canteen.model;

import java.util.Date;

public class Info {
    private Integer id;

    private Integer canteenid;

    private String info;

    private String pubtime;

    private Date validtime;

    private String canteenname;

    private String canteenphoto;

    public String getCanteenname() {
        return canteenname;
    }

    public void setCanteenname(String canteenname) {
        this.canteenname = canteenname;
    }

    public String getCanteenphoto() {
        return canteenphoto;
    }

    public void setCanteenphoto(String canteenphoto) {
        this.canteenphoto = canteenphoto;
    }

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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public String getPubtime() {
        return pubtime;
    }

    public void setPubtime(String pubtime) {
        this.pubtime = pubtime == null ? null : pubtime.trim();
    }

    public Date getValidtime() {
        return validtime;
    }

    public void setValidtime(Date validtime) {
        this.validtime = validtime;
    }
}