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

@WebServlet("/addCar")//设定访问路径
public class AddCarServlet extends HttpServlet {


    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ID值
        String fid=request.getParameter("fid");
        HttpSession session=request.getSession();
        int flowerid=0;
        //数据类型转换
        if(fid!=null&&!"".equals(fid)){
            flowerid=Integer.parseInt(fid);
            //将获取到的flowerid值存储到session中
            session.setAttribute("flowerid",flowerid);
        }else{
            //得到存储的flowerid
            flowerid= (int) session.getAttribute("flowerid");
        }
        Tuser tuser= (Tuser) session.getAttribute("tuser");
        //当tuser为空，表示此用户还未登录，那么需要跳转到登录页面
        if(tuser==null){
            request.setAttribute("result","请您先登录");
            request.setAttribute("type","car");//存储一个标志
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }else {
            TuserService tuserService = new TuserServiceImpl();
            List<Flower> flowers = null;
            try {
                flowers = tuserService.addCar(flowerid, tuser);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //页面需要此值，进行存储
            request.setAttribute("flowers", flowers);
            request.getRequestDispatcher("shoppingcart.jsp").forward(request, response);
        }
    }
}
