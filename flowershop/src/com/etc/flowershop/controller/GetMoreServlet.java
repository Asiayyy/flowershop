package com.etc.flowershop.controller;

import com.etc.flowershop.entity.Torder;
import com.etc.flowershop.service.TuserService;
import com.etc.flowershop.service.serviceImpl.TuserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/getMore")
public class GetMoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname") ;
        String startdate = request.getParameter("startdate") ;
        String enddate = request.getParameter("enddate") ;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd") ;
        Date start = null ;
        Date end = null ;
        if(startdate != null && !"".equals(startdate)){
            try {
                start = simpleDateFormat.parse(startdate) ;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(enddate != null && !"".equals(enddate)){
            try {
                end = simpleDateFormat.parse(enddate) ;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        TuserService tuserService = new TuserServiceImpl() ;
        try {
            List<Torder> orders = tuserService.getOrders(uname , start , end) ;
            request.setAttribute("orders" , orders);
            request.getRequestDispatcher("back.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
