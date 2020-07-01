package com.thlly.service.impl;

import com.thlly.dao.ImgDao;
import com.thlly.domain.Img;
import com.thlly.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgServiceImpl implements ImgService {
    @Autowired
    private ImgDao imgDao;
    @Override
    public boolean upImg(Img img) {
        return imgDao.save(img);
    }

    @Override
    public List<Img> showImg() {
        return imgDao.findAll();
    }
}
