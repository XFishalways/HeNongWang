package com.bug.henong.servlet;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.bug.henong.dao.BuyerUserDao;
import com.bug.henong.entity.BuyerUser;

@WebServlet(name = "getBuyerUsers", value = "/admin/GetBuyerUsers")
public class GetBuyerUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        BuyerUserDao buyerUserDao = new BuyerUserDao();
        String id = req.getParameter("USER_ID");
        String json = null;
        try {
            List<BuyerUser> users = buyerUserDao.findAll(id);
            if(users != null) {
                json = JSON.toJSONString(users);
                System.out.println(json);
            }
            else {
                json = "{\"log\":\"Invalid id\"}";
            }
        } catch (SQLException e) {
            json = "{\"log\":\"Error connection to database\"}";
        }
        System.out.println(json);
        pw.print(json);
    }
}
