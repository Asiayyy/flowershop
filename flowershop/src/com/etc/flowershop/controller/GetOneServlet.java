package com.etc.flowershop.controller;

import com.etc.flowershop.entity.Flower;
import com.etc.flowershop.service.TuserService;
import com.etc.flowershop.service.serviceImpl.TuserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet( "/GetOneServlet")
public class GetOneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //获取页面的id值
        String fid=request.getParameter("fid");
        //因为数据库中的fid值是int型，所以还需要进行数据类型转换
        int flowerid=0;
        if(fid!=null&&!"".equals(fid))
            flowerid=Integer.parseInt(fid);
        TuserService tuserService=new TuserServiceImpl();
        try{
            Flower flower=tuserService.getOne(flowerid);
            //因为页面中需要得到flower所以需要进行存储
            request.setAttribute("flower",flower);
            request.getRequestDispatcher("productdetail.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
