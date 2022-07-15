package com.bug.henong.service;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.SQLException;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class GoodsServiceTest {

    @Autowired
    GoodsService goodsService;

    @Test
    public void getGoodsId() {
        try {
            goodsService.getGoodsId("1");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateGoodsName() {
    }

    @Test
    public void updateQuantity() {
    }

    @Test
    public void updatePrice() {
    }

    @Test
    public void updateSale() {
    }

    @Test
    public void updatePass() {
    }

    @Test
    public void updatePassSalt() {
    }
}