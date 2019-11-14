package com.cskaoyan.controller;

import com.cskaoyan.bean.Account;
import com.cskaoyan.bean.Message;
import com.cskaoyan.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping("register")
    public ModelAndView register(Account account, HttpSession session) throws Exception {
        int id = accountService.register(account);
        account.setId(id);
        session.setAttribute("account", account);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", account.getUsername());
        modelAndView.addObject("result", "注册成功");
        modelAndView.setViewName("/result.jsp");
        return modelAndView;
    }

    @RequestMapping("login")
    public ModelAndView login(Account account, HttpSession session) {
        boolean login = accountService.login(account);


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", account.getUsername());
        if (login) {
            modelAndView.addObject("result", "登录成功");
            session.setAttribute("account", account);
        } else {
            modelAndView.addObject("result", "用户名或者密码错误");
            session.setAttribute("account", null);
        }

        modelAndView.setViewName("/result.jsp");
        return modelAndView;
    }

    @RequestMapping("showInfo")
    public ModelAndView showInfo(HttpSession session) {
        Account account = (Account) session.getAttribute("account");
        ModelAndView modelAndView = new ModelAndView();
        if (account != null) {
            modelAndView.addObject("username", account.getUsername());
            modelAndView.addObject("password", account.getPassword());
        } else {
            modelAndView.addObject("username", "对不起您未登陆");
        }
        modelAndView.setViewName("/information.jsp");
        return modelAndView;
    }
    @RequestMapping("message")
    public ModelAndView leaveMessage(String message,HttpSession session){
        Account account = (Account) session.getAttribute("account");
        accountService.leaveMessage(message,account);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username",account.getUsername());
        modelAndView.addObject("result","留言成功");
        modelAndView.setViewName("/result.jsp");
        return modelAndView;
    }
    @RequestMapping("checkMessage")
    public ModelAndView checkMessage(){
        ModelAndView modelAndView = new ModelAndView();
        Message[] messages=accountService.checkMessage();
        StringBuilder builder = new StringBuilder();
        for (Message message : messages) {
            String s=message.getUsername()+" : "+message.getMessage()+";    ";
            builder.append(s);
        }
        modelAndView.addObject("result",builder.toString());
        modelAndView.setViewName("/result.jsp");
        return modelAndView;
    }
}
