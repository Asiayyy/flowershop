package com.etc.flowershop.controller;

import com.etc.flowershop.entity.Flower;
import com.etc.flowershop.service.TuserService;
import com.etc.flowershop.service.serviceImpl.TuserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //因为要做分页，所以需要从页面中获取用户想要的显示哪一页的数据
        String page=request.getParameter("page");
        HttpSession session=request.getSession();
        int p=1;
        if(page==null||"".equals(page)) {
            p = 1;//当没有传递page，默认为第一页
        }else {
            p=Integer.parseInt(page);
        }
        TuserService tuserService=new TuserServiceImpl();
        List<Flower> flowers=null;
        List<Flower> flowerpruducts=null;
        try{
            flowers=tuserService.getAll(p,3);
            flowerpruducts=tuserService.getAll(1,100000);
            int total=tuserService.getTotal(3);
            //页面没有page,total,next,up值，对这四个数据进行存储
            session.setAttribute("page",p);
            session.setAttribute("total",total);
            session.setAttribute("next",p+1);
            session.setAttribute("up",p-1);
            session.setAttribute("flowerlist",flowers);
            session.setAttribute("flowerproducts",flowerpruducts);
            request.getRequestDispatcher("main.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
