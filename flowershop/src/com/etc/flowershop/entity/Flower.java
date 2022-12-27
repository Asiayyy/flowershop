package com.etc.flowershop.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Flower {
   private int flowerid;
   private String flowername;
   private String type;
   private String pic;
   private String show;
   private int price;
   private int count;
   List<Shopcar>listshopcar=new ArrayList<>();
   List<Detail>listdetail=new ArrayList<>();

    public Flower() {
    }

    public Flower(int flowerid, String flowername, String type, String pic, String show, int price, int count, List<Shopcar> listshopcar, List<Detail> listdetail) {
        this.flowerid = flowerid;
        this.flowername = flowername;
        this.type = type;
        this.pic = pic;
        this.show = show;
        this.price = price;
        this.count = count;
        this.listshopcar = listshopcar;
        this.listdetail = listdetail;
    }

    public int getFlowerid() {
        return flowerid;
    }

    public void setFlowerid(int flowerid) {
        this.flowerid = flowerid;
    }

    public String getFlowername() {
        return flowername;
    }

    public void setFlowername(String flowername) {
        this.flowername = flowername;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Shopcar> getListshopcar() {
        return listshopcar;
    }

    public void setListshopcar(List<Shopcar> listshopcar) {
        this.listshopcar = listshopcar;
    }

    public List<Detail> getListdetail() {
        return listdetail;
    }

    public void setListdetail(List<Detail> listdetail) {
        this.listdetail = listdetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return flowerid == flower.flowerid &&
                price == flower.price &&
                count == flower.count &&
                Objects.equals(flowername, flower.flowername) &&
                Objects.equals(type, flower.type) &&
                Objects.equals(pic, flower.pic) &&
                Objects.equals(show, flower.show) &&
                Objects.equals(listshopcar, flower.listshopcar) &&
                Objects.equals(listdetail, flower.listdetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flowerid, flowername, type, pic, show, price, count, listshopcar, listdetail);
    }

    @Override
    public String toString() {
        return "Flower{" +
                "flowerid=" + flowerid +
                ", flowername='" + flowername + '\'' +
                ", type='" + type + '\'' +
                ", pic='" + pic + '\'' +
                ", show='" + show + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", listshopcar=" + listshopcar +
                ", listdetail=" + listdetail +
                '}';
    }
}
