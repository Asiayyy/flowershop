package com.etc.flowershop.entity;

import java.util.Objects;

public class Detail {
    private int detailid;
    private Torder torder;
    private Flower flower;
    private int payone;
    private String onecout;

    public Detail() {
    }

    public Detail(int detailid, Torder torder, Flower flower, int payone, String onecout) {
        this.detailid = detailid;
        this.torder = torder;
        this.flower = flower;
        this.payone = payone;
        this.onecout = onecout;
    }

    public int getDetailid() {
        return detailid;
    }

    public void setDetailid(int detailid) {
        this.detailid = detailid;
    }

    public Torder getTorder() {
        return torder;
    }

    public void setTorder(Torder torder) {
        this.torder = torder;
    }

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    public int getPayone() {
        return payone;
    }

    public void setPayone(int payone) {
        this.payone = payone;
    }

    public String getOnecout() {
        return onecout;
    }

    public void setOnecout(String onecout) {
        this.onecout = onecout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detail detail = (Detail) o;
        return detailid == detail.detailid &&
                payone == detail.payone &&
                Objects.equals(torder, detail.torder) &&
                Objects.equals(flower, detail.flower) &&
                Objects.equals(onecout, detail.onecout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(detailid, torder, flower, payone, onecout);
    }

    @Override
    public String toString() {
        return "Detail{" +
                "detailid=" + detailid +
                ", torder=" + torder +
                ", flower=" + flower +
                ", payone=" + payone +
                ", onecout='" + onecout + '\'' +
                '}';
    }
}
