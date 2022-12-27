package com.etc.flowershop.controller;

import com.etc.flowershop.entity.Address;
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
import java.util.Map;

@WebServlet("/pay")
public class PayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TuserService tuserService=new TuserServiceImpl();
        HttpSession session=request.getSession();
        Tuser tuser=(Tuser)session.getAttribute("tuser");
        Integer sum=(Integer)session.getAttribute("sum");
        String []ids=(String[])session.getAttribute("ids");
        Map<String,Integer> countmap= (Map<String, Integer>) session.getAttribute("countmap");
        Map<String,Integer> paymap= (Map<String, Integer>) session.getAttribute("paymap");
        try {
            tuserService.pay(tuser,sum,ids,countmap,paymap);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("over.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
