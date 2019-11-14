package com.cskaoyan.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccountHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) {
        ModelAndView modelAndView = new ModelAndView();
        if(exception instanceof ParameterException){
            ParameterException parameterException= (ParameterException) exception;
            String parameter = parameterException.getParameter();
            modelAndView.addObject("parameter",parameter);
            modelAndView.addObject("message",parameterException.getMessage());
            String contextPath = request.getContextPath();
//            System.out.println("contextPath"+contextPath);
            modelAndView.setViewName("/exception.jsp");
        }
        return modelAndView;
    }
}
