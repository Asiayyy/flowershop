package com.etc.flowershop.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tuser {
   private int tuserid;
   private String username;
   private String pwd;
   private int role;
   private String phone;
   private String email;
   List<Address> listAddress=new ArrayList<>();
   List<Torder>listTorder=new ArrayList<>();
   List<Shopcar>listShopcar=new ArrayList<>();

    public int getTuserid() {
        return tuserid;
    }

    public void setTuserid(int tuserid) {
        this.tuserid = tuserid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Address> getListAddress() {
        return listAddress;
    }

    public void setListAddress(List<Address> listAddress) {
        this.listAddress = listAddress;
    }

    public List<Torder> getListTorder() {
        return listTorder;
    }

    public void setListTorder(List<Torder> listTorder) {
        this.listTorder = listTorder;
    }

    public List<Shopcar> getListShopcar() {
        return listShopcar;
    }

    public void setListShopcar(List<Shopcar> listShopcar) {
        this.listShopcar = listShopcar;
    }

    public Tuser() {
    }

    public Tuser(int tuserid) {
        this.tuserid = tuserid;
    }

    public Tuser(int tuserid, String username, String pwd, int role, String phone, String email, List<Address> listAddress, List<Torder> listTorder, List<Shopcar> listShopcar) {
        this.tuserid = tuserid;
        this.username = username;
        this.pwd = pwd;
        this.role = role;
        this.phone = phone;
        this.email = email;
        this.listAddress = listAddress;
        this.listTorder = listTorder;
        this.listShopcar = listShopcar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuser tuser = (Tuser) o;
        return tuserid == tuser.tuserid &&
                role == tuser.role &&
                Objects.equals(username, tuser.username) &&
                Objects.equals(pwd, tuser.pwd) &&
                Objects.equals(phone, tuser.phone) &&
                Objects.equals(email, tuser.email) &&
                Objects.equals(listAddress, tuser.listAddress) &&
                Objects.equals(listTorder, tuser.listTorder) &&
                Objects.equals(listShopcar, tuser.listShopcar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tuserid, username, pwd, role, phone, email, listAddress, listTorder, listShopcar);
    }

    @Override
    public String toString() {
        return "Tuser{" +
                "tuserid=" + tuserid +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", role=" + role +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", listAddress=" + listAddress +
                ", listTorder=" + listTorder +
                ", listShopcar=" + listShopcar +
                '}';
    }
}
