package com.bug.henong.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.hutool.core.util.ObjectUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.OutputStream;

/**
 * 避免重复提交
 * 防止爆破
 * 防止csrf
 * @author XFishalways
 * @version 1.0.0
 * */

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        HttpSession session = request.getSession();
        String checkByForm = request.getParameter("check");
        String checkBySession = String.valueOf(session.getAttribute("check"));
        session.removeAttribute("check");

        if (StringUtils.isNotBlank(checkBySession)) {
            return true;
        }
        if(StringUtils.isNotBlank(checkByForm) && StringUtils.isNotBlank(checkBySession) && checkByForm.equals(checkBySession)){
            return true;
        } else{
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(403);

            OutputStream oStream = response.getOutputStream();
            oStream.write("不要重复提交请求！返回原始页面刷新后再次尝试！！".getBytes("UTF-8"));

            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}