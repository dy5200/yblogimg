package com.thlly.controller;

import com.thlly.domain.User;
import com.thlly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/register")
    @ResponseBody
    public String register(User user) throws IOException {
        System.out.println(user);
        if(userService.register(user)){
            return "{\"code\":200,\"msg\":\"注册成功！\"}";
        }else {
            return   "{\"code\":404,\"msg\":\"注册失败！\"}";
        }
    }

    @RequestMapping("/login")
    public String login(User user,HttpServletRequest request, HttpServletResponse response) throws IOException {
        User exisuser = userService.login(user);
        request.getSession().setAttribute("user",exisuser);
        response.setCharacterEncoding("UTF-8");
        if(exisuser!=null){
            response.getWriter().write("{\"code\":200,\"msg\":\"登录成功！\"}");
        }else {
            response.getWriter().write("{\"code\":404,\"msg\":\"账号或密码错误！\"}");

        }
        return "redirect:/";
    }
}
