package com.etc.flowershop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Torder {
    private Tuser tuser;
    private String orderid;
    private Date date;
    private int paysum;
    List<Detail> detailList=new ArrayList<>();

    public Torder() {
    }

    public Torder(Tuser tuser, String orderid, Date date, int paysum, List<Detail> detailList) {
        this.tuser = tuser;
        this.orderid = orderid;
        this.date = date;
        this.paysum = paysum;
        this.detailList = detailList;
    }

    public Tuser getTuser() {
        return tuser;
    }

    public void setTuser(Tuser tuser) {
        this.tuser = tuser;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPaysum() {
        return paysum;
    }

    public void setPaysum(int paysum) {
        this.paysum = paysum;
    }

    public List<Detail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<Detail> detailList) {
        this.detailList = detailList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Torder torder = (Torder) o;
        return orderid == torder.orderid &&
                paysum == torder.paysum &&
                Objects.equals(tuser, torder.tuser) &&
                Objects.equals(date, torder.date) &&
                Objects.equals(detailList, torder.detailList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tuser, orderid, date, paysum, detailList);
    }

    @Override
    public String toString() {
        return "Torder{" +
                "tuser=" + tuser +
                ", orderid=" + orderid +
                ", date=" + date +
                ", paysum=" + paysum +
                ", detailList=" + detailList +
                '}';
    }
}
