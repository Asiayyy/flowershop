package com.etc.flowershop.dao.daoImpl;

import com.etc.flowershop.dao.BaseDao;

import java.sql.*;

public class BaseDaoImpl implements BaseDao {
    //定义需要使用的JDBC对象
    public Connection con;
    public PreparedStatement ps ;
    public ResultSet rs ;
    public Statement st;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        new BaseDaoImpl().openDB();
    }
    //连接数据库

    @Override
    public void openDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //连接数据库：url表示连接的地址，user表示用户名,password表示安装数据库时的密码
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flowershop?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT"
                ,"root" , "200304") ;
        System.out.println("成功连接啦。。。。。。。。。。。。。。。。。");
    }

    //关闭资源
    @Override
    public void closeResoure() throws SQLException {
        if(con!=null)
            con.close();
        if(ps!=null)
            ps.close();
        if(rs!=null)
            rs.close();
        if(st!=null)
            st.close();
    }

    @Override
    public void openTransaction() throws SQLException, ClassNotFoundException {
        //打开事务，就是关闭数据库的自动提交功能
        openDB();
        con.setAutoCommit(false);
    }

    @Override
    public void commitTransaction() throws SQLException {
       //提交事务
        if(con!=null){
            con.commit();
        }
    }

    @Override
    public void rollbackTransaction() throws SQLException {
        //事务回滚
        if (con!=null) {
            con.rollback();
        }
    }
}
