package com.thlly.service;

import com.thlly.domain.Img;

import java.util.List;

public interface ImgService {

    boolean upImg(Img img);

    List<Img> showImg();
}
