package com.example.canteen.model;

import java.util.Date;

public class Dish {
    private Integer id;

    private Integer canteenid;

    private String name;

    private Double price;

    private String photo;

    private String introduce;

    private Integer salesvolume;

    private Date createtime;

    private Integer deleted;

    private Integer num;

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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public Integer getSalesvolume() {
        return salesvolume;
    }

    public void setSalesvolume(Integer salesvolume) {
        this.salesvolume = salesvolume;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}