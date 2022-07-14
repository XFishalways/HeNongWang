package com.bug.henong.controller;

import com.bug.henong.dao.BuyerUserDao;
import com.bug.henong.entity.BuyerUser;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping(value = "/GetBuyerUser", method = RequestMethod.GET)

public class test {
    @GetMapping("/test")
    public BuyerUser test() throws SQLException {
        BuyerUserDao dao = new BuyerUserDao();
        BuyerUser user =dao.findOneBuyer("1");
        return user;
    }

}
