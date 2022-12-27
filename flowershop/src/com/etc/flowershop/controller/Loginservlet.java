package com.etc.flowershop.controller;

import com.etc.flowershop.entity.Flower;
import com.etc.flowershop.entity.Tuser;

import com.etc.flowershop.service.TuserService;
import com.etc.flowershop.service.serviceImpl.TuserServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/login")
public class Loginservlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //获取标识内容
        String type=req.getParameter("type");
        /*
        1.获取页面的用户名和密码
        2.想要获取哪个控件中的数据就需要得到哪个控件中的name属性
        3.使用getParameter方法得到的数据都是String类型
         */
        String username=req.getParameter("Username");
        String pwd=req.getParameter("Password");
        //创建service对象，servlet是一个路径一个对象，service通常是一个功能模块一个对象
        //面向接口编程，（多态体现），左方是接口，右方是实现类
        TuserService tuserService=new TuserServiceImpl();
        try {
            //调用登录方法
            Tuser tuser=tuserService.login(username,pwd);
            if(tuser==null){
                //表示登录失败，回到登页面
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }else {
                //登录成功，将用户信息存储在session中
                HttpSession session=req.getSession();
                session.setAttribute("tuser",tuser);
                //从数据库中得到所有鲜花
                //List<Flower> flowers=tuserService.getAll();
                //先对flowers进行存储
                //request存储称为请求存储，相应一次就失效，第一个参数用来在页面中获取数据的名称
                //第二个参数是要得到的数据
                //req.setAttribute("flowerlist",flowers);
                //根据不同的类型跳到不同的页面
                if("car".equals(type))
                    req.getRequestDispatcher("/addCar").forward(req,resp);
                else
                req.getRequestDispatcher("MainServlet").forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
