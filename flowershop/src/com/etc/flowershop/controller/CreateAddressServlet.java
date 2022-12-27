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

@WebServlet("/AlterAddress")
public class CreateAddressServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String address=request.getParameter("address");
        String city=request.getParameter("city");
        String country=request.getParameter("country");
        Tuser tuser= (Tuser) request.getSession().getAttribute("tuser");
        TuserService tuserService=new TuserServiceImpl();
        int id=tuser.getTuserid();
        try {
            tuserService.UpdateAddress(id,address);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            tuserService.UpdateCity(id,city);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            tuserService.UpdateCountry(id,country);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String fullname=tuser.getUsername();
        HttpSession session=request.getSession();
        try {
            Address newaddress = tuserService.getAddress(tuser.getTuserid());
            session.setAttribute("address",newaddress);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("checkout.jsp").forward(request,response);
    }
}
