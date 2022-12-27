package com.etc.flowershop.dao;

import com.etc.flowershop.entity.Address;
import com.etc.flowershop.entity.Flower;
import com.etc.flowershop.entity.Torder;
import com.etc.flowershop.entity.Tuser;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface TuserDao extends BaseDao {
    Tuser login(String username,String pwd) throws SQLException, ClassNotFoundException;

    List<Flower> getAll(int p,int i) throws SQLException, ClassNotFoundException;

    Flower getOne(int fid) throws SQLException, ClassNotFoundException;

    //判断购物车内是否有鲜花
    Boolean judge(Tuser tuser, int flowerid) throws SQLException, ClassNotFoundException;
    //添加购物车
    void addCar(Tuser tuser, int flowerid) throws SQLException, ClassNotFoundException;
    //显示购物车信息
    List<Flower> showCar(Tuser tuser) throws SQLException, ClassNotFoundException;
    //观赏类
    List<Flower> showtype() throws SQLException, ClassNotFoundException;
    //居家类
    List<Flower> hometype() throws SQLException, ClassNotFoundException;
    //环保类
    List<Flower> environmentaltype() throws SQLException, ClassNotFoundException;
    //药用类
    List<Flower> medicinetype() throws SQLException, ClassNotFoundException;
    //花篮类
    List<Flower> baskettype() throws SQLException, ClassNotFoundException;
    //修改账户余额
    void updateUser(Tuser tuser, int pay) throws SQLException;
    //修改鲜花数量
    void updateFlower(int i, int count) throws SQLException;
    //添加订单
    void addOrder(String orderid, Tuser tuser, int pay) throws SQLException;
    //完成订单详情
    void addDetail(String orderid, int i, int payone, int count) throws SQLException;
    //清空购物车
    void deletCar(Tuser tuser, int i) throws SQLException;
    //计算一共有多少页
    int getTotal(int i) throws SQLException, ClassNotFoundException;
    //得到地址
    Address getAddress(int tuserid) throws SQLException, ClassNotFoundException;
    //搜索指定鲜花
    Flower getSearch(String flowername) throws SQLException, ClassNotFoundException;
    //多条件查询订单信息
    List<Torder> getOrders(String name, Date start, Date end) throws SQLException, ClassNotFoundException;
    //得到用户购物车里的所有鲜花
    List<Flower> getTuserflower(Tuser tuser) throws SQLException, ClassNotFoundException;
    //清空购物车里的某一项
    void deletCarone(Tuser tuser, int flowerid) throws SQLException, ClassNotFoundException;
    //添加新用户
    void addUser(String name, String email, String pwd, String number) throws SQLException, ClassNotFoundException;

    void UpdateAddress(int id, String address) throws SQLException, ClassNotFoundException;

    void UpdateCity(int id, String city) throws SQLException, ClassNotFoundException;

    void UpdateCountry(int id, String country) throws SQLException, ClassNotFoundException;
}
