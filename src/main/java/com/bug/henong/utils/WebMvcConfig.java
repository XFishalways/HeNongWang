//package com.bug.henong.utils;
//
//import com.bug.henong.interceptor.LoginInterceptor;
//import com.bug.henong.interceptor.SqlInjectInterceptor;
//import com.google.common.collect.Lists;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//@EnableAspectJAutoProxy
//public class WebMvcConfig extends WebMvcConfigurationSupport {
//    @Autowired(required = false)
//    private LoginInterceptor loginInterceptor;
//    @Autowired(required = false)
//    private SqlInjectInterceptor sqlInjectInterceptor;
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        // 单页面应用路由配置
//        //-------------------------
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/static/")
//                .setCachePeriod(600);
//        //----------------------------
//
//    }
//
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        List<String> patterns = Lists.newArrayList();
//        patterns.add("/**");
//        // 登陆拦截器
//        registry.addInterceptor(loginInterceptor).addPathPatterns(patterns);
//        // 添加sql注入拦截器
//        registry.addInterceptor(sqlInjectInterceptor).addPathPatterns("/api/**");
//        super.addInterceptors(registry);
//    }
//}
