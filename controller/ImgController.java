package com.thlly.controller;

import com.thlly.domain.Img;
import com.thlly.domain.User;
import com.thlly.service.ImgService;
import com.thlly.utils.UploadImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class ImgController {
    @Autowired
    private ImgService imgService;
    private static Random rd = new  Random();
    @RequestMapping("/imgUpload")
    @ResponseBody
    public String imgUpload(MultipartFile file, HttpServletRequest request) throws IOException {
        Img img = new Img();
        User user = (User) request.getSession().getAttribute("user");
        img.setUploadUsername(user.getUsername());
        img.setImgUrl(UploadImg.uploadImg(file.getBytes(), file.getOriginalFilename()));
        String date = new SimpleDateFormat("yyyy年mm月dd日 hh时mm分ss秒").format(new Date());
        System.out.println(date);
        img.setUserUpDate(date);
        System.out.println(img.getImgUrl());
        imgService.upImg(img);
        return "{\"code\":200,\"imgUrl\":\""+ img.getImgUrl() +"\"}";
    }
    @RequestMapping("/imgList")
    @ResponseBody
    public List<Img> imgList() throws IOException {
        List<Img> imgs = imgService.showImg();
        List<Img> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(imgs.get(rd.nextInt(imgs.size())));
        }
        return list;
    }
}
