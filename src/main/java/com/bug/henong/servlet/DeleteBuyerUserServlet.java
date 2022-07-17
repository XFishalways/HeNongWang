package com.bug.henong.servlet;

import com.alibaba.fastjson.JSON;
import com.bug.henong.dao.BuyerUserDao;
import com.bug.henong.entity.BuyerUser;
import com.bug.henong.utils.MapFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


/**
 * @author Tan
 */
@WebServlet(name = "deleteBuyerUser",value = "/DeleteBuyerUserServlet")
public class DeleteBuyerUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        BuyerUserDao buyerUserDao = new BuyerUserDao();
        String id = req.getParameter("USER_ID");
        System.out.println(id);
        String json = null;
        try {
            int rw = buyerUserDao.delete(id);
            if(rw>0) {
                MapFactory mapFactory = new MapFactory();
                json = mapFactory.getStringObjectMap();
            }
            else {
                json = null;
            }
        } catch (SQLException e) {
            json = null;
        }
        System.out.println(json);
        pw.print(json);
        pw.flush();
        pw.close();
    }
}
