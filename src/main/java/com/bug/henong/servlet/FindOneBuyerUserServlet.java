package com.bug.henong.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.alibaba.fastjson.JSON;
import com.bug.henong.dao.BuyerUserDao;
import com.bug.henong.entity.BuyerUser;

/**
 * @author XFishalways
 */
@WebServlet(name = "findOneBuyerUserServlet", value = "/FindOneBuyerUser")
public class FindOneBuyerUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("test");
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        BuyerUserDao buyerUserDao = new BuyerUserDao();
        String id = req.getParameter("USER_ID");
        String json = null;
        try {
            BuyerUser user = buyerUserDao.findOneBuyer(id);
            if(user != null) {
                json = JSON.toJSONString(user);
                System.out.println(json);
            }
            else {
                json = "{\"log\":\"Invalid id\"}";
            }
        } catch (SQLException e) {
            json = "{\"log\":\"Error connection to database\"}";
        }
        pw.print(json);

    }
}

