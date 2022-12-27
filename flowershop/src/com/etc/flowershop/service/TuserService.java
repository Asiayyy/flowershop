package com.etc.flowershop.service;

import com.etc.flowershop.entity.Address;
import com.etc.flowershop.entity.Flower;
import com.etc.flowershop.entity.Torder;
import com.etc.flowershop.entity.Tuser;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TuserService{
    //登录
    Tuser login(String username, String pwd) throws SQLException;
    //显示所有鲜花
    List<Flower> getAll(int page,int i) throws SQLException;
    //显示某个鲜花详情
    Flower getOne(int fid) throws SQLException;
    //添加购物车
    List<Flower> addCar(int flowerid,Tuser tuser) throws SQLException;
    //观赏类
    List<Flower> showtype() throws SQLException;
    //居家类
    List<Flower> hometype() throws SQLException;
    //环保类
    List<Flower> environmentaltype() throws SQLException;
    //药用类
    List<Flower> medicinetype() throws SQLException;
    //花篮类
    List<Flower> baskettype() throws SQLException;
    //支付功能
    public void pay(Tuser tuser, int pay, String[]ids, Map<String,Integer>countmap, Map<String,Integer>paymap) throws SQLException;
    //计算总共有多少页面
    int getTotal(int i) throws SQLException;

    Address getAddress(int tuserid) throws SQLException;
    //搜索指定鲜花
    Flower getSearch(String flowername) throws SQLException;
    //多条件查询订单信息
    List<Torder> getOrders(String name, Date start,Date end) throws SQLException;
    //删除购物车里的鲜花
    List<Flower> deleteCar(int flowerid, Tuser tuser) throws SQLException;
    //注册新用户
    void addUser(String name, String email, String pwd, String number) throws SQLException;

    void UpdateAddress(int id, String address) throws SQLException;

    void UpdateCity(int id, String city) throws SQLException;

    void UpdateCountry(int id, String country) throws SQLException;
}


