package com.etc.flowershop.dao;

import com.mysql.cj.protocol.a.SqlDateValueEncoder;

import java.sql.SQLException;

public interface BaseDao {
    //打开数据库
    public void openDB() throws ClassNotFoundException, SQLException;
    //关闭资源
    public void closeResoure() throws SQLException;
    //打开事务
    public  void openTransaction() throws SQLException, ClassNotFoundException;
    //提及事务
    public void commitTransaction()throws SQLException;
    //事务回滚
    public void rollbackTransaction()throws SQLException;
}