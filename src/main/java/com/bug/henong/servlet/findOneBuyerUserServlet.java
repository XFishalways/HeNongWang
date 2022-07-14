package com.bug.henong.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import cn.hutool.json.JSONUtil;
import com.bug.henong.dao.BuyerUserDao;
import com.bug.henong.entity.BuyerUser;

@WebServlet(name = "findAllBuyerUserServlet", value = "/BuyerUser")
public class findOneBuyerUserServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        BuyerUserDao buyerUserDao = new BuyerUserDao();
        String id = req.getParameter("USER_ID");
        try {
            System.out.println(buyerUserDao.findOneBuyer(id).getUserId());
            System.out.println(buyerUserDao.findOneBuyer(id).getUserName());
            System.out.println(buyerUserDao.findOneBuyer(id).getNickName());
            System.out.println(buyerUserDao.findOneBuyer(id).getUserIntro();
            System.out.println(buyerUserDao.findOneBuyer(id).getPhone());
            System.out.println(buyerUserDao.findOneBuyer(id).getAvatar());
            System.out.println(buyerUserDao.findOneBuyer(id).getUserPass());
            System.out.println(buyerUserDao.findOneBuyer(id).getPassSalt());
            System.out.println(buyerUserDao.findOneBuyer(id).getTotalCostAmt());
            System.out.println(buyerUserDao.findOneBuyer(id).getLastLoginTime());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
