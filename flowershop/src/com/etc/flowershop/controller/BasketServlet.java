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
import java.util.List;

@WebServlet("/BasketServlet")
public class BasketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TuserService tuserService=new TuserServiceImpl();
        List<Flower> flowers=null;
        try {
            flowers = tuserService.baskettype();
            //因为页面中需要得到flower所以需要进行存储
            request.setAttribute("flowerlist", flowers);
            request.getRequestDispatcher("baskettype.jsp").forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
