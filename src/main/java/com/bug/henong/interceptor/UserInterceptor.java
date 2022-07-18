package com.bug.henong.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 无session时 将由个人中心后台跳回至login登录
 * @author XFishalays
 * @version 1.0.0
 */
public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle (HttpServletRequest request,
                              HttpServletResponse response,
                              Object handler) throws Exception {

        HttpSession session = request.getSession();

        Object checker = session.getAttribute("userId");
        if(checker == null) {
            response.sendRedirect("login.html");
            return false;
        }

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
