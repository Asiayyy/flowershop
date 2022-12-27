package com.etc.flowershop.entity;

import java.util.List;
import java.util.Objects;

public class Shopcar {
   private int shopcarid;
   private Tuser tuser;
   private Flower flower;

    public Shopcar() {
    }

    public Shopcar(int shopcarid, Tuser tuser, Flower flower) {
        this.shopcarid = shopcarid;
        this.tuser = tuser;
        this.flower = flower;
    }

    public int getShopcarid() {
        return shopcarid;
    }

    public void setShopcarid(int shopcarid) {
        this.shopcarid = shopcarid;
    }

    public Tuser getTuser() {
        return tuser;
    }

    public void setTuser(Tuser tuser) {
        this.tuser = tuser;
    }

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shopcar shopcar = (Shopcar) o;
        return shopcarid == shopcar.shopcarid &&
                Objects.equals(tuser, shopcar.tuser) &&
                Objects.equals(flower, shopcar.flower);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopcarid, tuser, flower);
    }

    @Override
    public String toString() {
        return "Shopcar{" +
                "shopcarid=" + shopcarid +
                ", tuser=" + tuser +
                ", flower=" + flower +
                '}';
    }
}
