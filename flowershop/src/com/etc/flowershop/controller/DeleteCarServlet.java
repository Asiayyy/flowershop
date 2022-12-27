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
import java.util.List;

@WebServlet("/DeleteCarServlet")
public class DeleteCarServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ID值
        String fid=request.getParameter("deletefid");
        HttpSession session=request.getSession();
        int flowerid=0;
        //数据类型转换
        flowerid=Integer.parseInt(fid);
        Tuser tuser= (Tuser) session.getAttribute("tuser");
        TuserService tuserService = new TuserServiceImpl();
        List<Flower> flowers = null;
        try {
            flowers = tuserService.deleteCar(flowerid, tuser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //页面需要此值，进行存储
            request.setAttribute("flowers", flowers);
            request.getRequestDispatcher("shoppingcart.jsp").forward(request, response);
        }
    }
