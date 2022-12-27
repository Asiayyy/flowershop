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
import java.util.HashMap;
import java.util.Map;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到所有选择鲜花的id值
        String []ids=request.getParameterValues("one");
        //定有一个变量，用来存储支付的总价
        int sum=0;
        //遍历所选鲜花，得到每个选择鲜花的总价
        //定义一个map集合，用来存储鲜花数量
        Map<String,Integer> countmap=new HashMap<>();
        //定义一个map集合，用来存储鲜花支付总额
        Map<String,Integer> paymap=new HashMap<>();
        for (String i : ids) {
            String one = request.getParameter("sum" + i);
            int sumone = 0;
            if (one != null && !"".equals(one)) {
                sumone = Integer.parseInt(one);
                paymap.put(i,sumone);
                sum += sumone;
            }
            //获取每个鲜花的购买数量
            String count = request.getParameter("quantity1" + i);
            int onecount=0;
            if(count!=null&&!"".equals(count))
                onecount=Integer.parseInt(count);
            countmap.put(i,onecount);
        }
        //获取用户信息及地址
        Tuser tuser= (Tuser) request.getSession().getAttribute("tuser");
        TuserService tuserService=new TuserServiceImpl();
        String fullname=tuser.getUsername();
        HttpSession session=request.getSession();
        try {
            Address address = tuserService.getAddress(tuser.getTuserid());
            session.setAttribute("address",address);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        session.setAttribute("sum",sum);
        session.setAttribute("ids",ids);
        session.setAttribute("countmap",countmap);
        session.setAttribute("paymap",paymap);
        request.setAttribute("fullname",fullname);
        request.getRequestDispatcher("checkout.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
