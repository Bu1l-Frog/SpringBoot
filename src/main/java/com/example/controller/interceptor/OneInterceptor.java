package com.example.controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OneInterceptor implements HandlerInterceptor {

    /**
     * 在请求处理之前进行调用(Controller方法调用前)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("被one拦截,方行...");
        return true;
    }

    /**
     * 在请求处理之后进行调用，但是在视图被渲染之前(Controller方法调用后)
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //TODO
    }

    /**
     * 在整个请求结束之后进行调用，也就是在DispatcherServlet渲染了对应的视图之后执行
     * （主要用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //TODO
    }
}
