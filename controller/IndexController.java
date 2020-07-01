package com.thlly.controller;

import com.thlly.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(Model model){
        return "index";
    }

    @RequestMapping("/list")
    public String imgList(Model model){
        return "imglist";
    }


    @RequestMapping("/ceshi")
    public String ceshi(Model model){
        return "ceshi";
    }
}
