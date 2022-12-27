package com.etc.flowershop.service.serviceImpl;

import com.etc.flowershop.dao.TuserDao;
import com.etc.flowershop.dao.daoImpl.TuserDaoImpl;
import com.etc.flowershop.entity.Address;
import com.etc.flowershop.entity.Flower;
import com.etc.flowershop.entity.Torder;
import com.etc.flowershop.entity.Tuser;
import com.etc.flowershop.service.TuserService;
import com.etc.flowershop.util.Orderid;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TuserServiceImpl implements TuserService {
    //完成登录功能
    @Override
    public Tuser login(String username, String pwd) throws SQLException {
        //创建持久化对象
        TuserDao tuserDao =new TuserDaoImpl();
        Tuser tuser=new Tuser();
        try{
           tuser= tuserDao.login(username,pwd);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            tuserDao.closeResoure();
        }
        return tuser;
    }

    @Override
    public List<Flower> getAll(int p,int i) throws SQLException {
        TuserDao tuserDao=new TuserDaoImpl();
        List<Flower> flowerlist=new ArrayList<>();
        try{
            flowerlist=tuserDao.getAll(p,i);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            tuserDao.closeResoure();
        }
        return flowerlist;
    }
    //显示鲜花详情
    @Override
    public Flower getOne(int fid) throws SQLException {
        TuserDao dao = new TuserDaoImpl();
        Flower flower = null;
        try{
            flower=dao.getOne(fid);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dao.closeResoure();
        }
        return flower;
    }
    //1.向购物车中添加鲜花，需要先判断购物车中是否已经存在鲜花
    //2.如果购物车中没有此鲜花，则向购物车添加此鲜花
    //3.将购物车中的信息显示在购物车中
    public List<Flower> addCar(int flowerid,Tuser tuser) throws SQLException {
        TuserDao dao=new TuserDaoImpl();
        List<Flower>flowers=null;
        try{
            Boolean flag=dao.judge(tuser,flowerid);
            if(flag){
                //如果有鲜花，不做任何操作
            }else{
                dao.addCar(tuser,flowerid);
            }
            //将购物车中的信息显示在购物车中
            flowers=dao.showCar(tuser);
        }catch (Exception e){

        }finally {
            dao.closeResoure();
        }
        return flowers;

    }
    //观赏类
    @Override
    public List<Flower> showtype() throws SQLException {
        TuserDao dao=new TuserDaoImpl();
        List<Flower>flowers=null;
        try{
            flowers=dao.showtype();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dao.closeResoure();
        }
        return flowers;
    }
    //居家类
    @Override
    public List<Flower> hometype() throws SQLException {
        TuserDao dao=new TuserDaoImpl();
        List<Flower>flowers=null;
        try{
            flowers=dao.hometype();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dao.closeResoure();
        }
        return flowers;
    }
    //环保类
    @Override
    public List<Flower> environmentaltype() throws SQLException {
        TuserDao dao=new TuserDaoImpl();
        List<Flower>flowers=null;
        try{
            flowers=dao.environmentaltype();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dao.closeResoure();
        }
        return flowers;
    }
    //药用类
    @Override
    public List<Flower> medicinetype() throws SQLException {
        TuserDao dao=new TuserDaoImpl();
        List<Flower>flowers=null;
        try{
            flowers=dao.medicinetype();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dao.closeResoure();
        }
        return flowers;
    }
    //花篮类
    @Override
    public List<Flower> baskettype() throws SQLException {
        TuserDao dao=new TuserDaoImpl();
        List<Flower>flowers=null;
        try{
            flowers=dao.baskettype();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dao.closeResoure();
        }
        return flowers;
    }
    public void pay(Tuser tuser, int pay, String[]ids, Map<String,Integer>countmap,Map<String,Integer>paymap) throws SQLException {
        TuserDao dao=new TuserDaoImpl();
        try{
            //打开事务
            dao.openTransaction();
            //1.用户余额减少
            dao.updateUser(tuser,pay);
            //2.修改鲜花数量
            for (String id : ids) {
                int i=0;
                if (id!=null&&!"".equals(id)){
                    //得到鲜花数量
                    int count=countmap.get(id);
                    i=Integer.parseInt(id);
                    dao.updateFlower(i,count);
                }
            }
            //3.生成订单,订单号(随机生成）
            String orderid= Orderid.getOrderNum(tuser.getTuserid());
            dao.addOrder(orderid,tuser,pay);
            //4.完成订单详情
            for (String id : ids) {
                int i=0;
                if(id!=null&&!"".equals(id)){
                    //从paymap中取出每个鲜花的支付总额
                    int payone=paymap.get(id);
                    //从countmap中取出每个鲜花的购买数量
                    int count=countmap.get(id);
                    i=Integer.parseInt(id);
                    dao.addDetail(orderid,i,payone,count);
                    //5.清空购物车
                    dao.deletCar(tuser,i);
                }
            }
            //提交事务
            dao.commitTransaction();
        }catch (Exception e){
            e.printStackTrace();
            //事务回滚
            dao.rollbackTransaction();
        }finally {
            //关闭数据资源
            dao.closeResoure();
        }
    }
    //计算一共有多少页
    @Override
    public int getTotal(int i) throws SQLException {
        TuserDao dao=new TuserDaoImpl();
        int total=0;
        try{
            total=dao.getTotal(i);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dao.closeResoure();
        }
        return total;
    }

    @Override
    public Address getAddress(int tuserid) throws SQLException {
        TuserDao dao=new TuserDaoImpl();
        Address address=null;
        try{
            address=dao.getAddress(tuserid);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dao.closeResoure();
        }
        return address;
    }

    @Override
    public Flower getSearch(String flowername) throws SQLException {
        TuserDao dao=new TuserDaoImpl();
        Flower flower=null;
        try{
            flower=dao.getSearch(flowername);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dao.closeResoure();
        }
        return flower;
    }
    //多条件查询订单信息
    @Override
    public List<Torder> getOrders(String name, Date start, Date end) throws SQLException {
        TuserDao dao=new TuserDaoImpl();
        List<Torder> torders=new ArrayList<>();
        try{
            torders=dao.getOrders(name,start,end);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            dao.closeResoure();
        }
        return torders;
    }
    //删除购物车的某一项
    @Override
    public List<Flower> deleteCar(int flowerid, Tuser tuser) throws SQLException {
        TuserDao dao=new TuserDaoImpl();
        List<Flower> flowers=new ArrayList<>();
        try {
            dao.deletCarone(tuser, flowerid);
            flowers=dao.getTuserflower(tuser);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dao.closeResoure();
        }
        return flowers;
    }
    //注册新用户
    @Override
    public void addUser(String name, String email, String pwd, String number) throws SQLException {
        TuserDao dao=new TuserDaoImpl();
        try {
            dao.addUser(name,email,pwd,number);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dao.closeResoure();
        }
    }

    @Override
    public void UpdateAddress(int id, String address) throws SQLException {
        TuserDao dao=new TuserDaoImpl();
        try {
            dao.UpdateAddress(id,address);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dao.closeResoure();
        }
    }

    @Override
    public void UpdateCity(int id, String city) throws SQLException {
        TuserDao dao=new TuserDaoImpl();
        try {
            dao.UpdateCity(id,city);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dao.closeResoure();
        }
    }

    @Override
    public void UpdateCountry(int id, String country) throws SQLException {
        TuserDao dao=new TuserDaoImpl();
        try {
            dao.UpdateCountry(id,country);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dao.closeResoure();
        }
    }

}
