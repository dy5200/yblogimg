package com.thlly.dao;

import com.thlly.domain.Img;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ImgDao {
    @Insert("insert into img(uploadUsername,imgUrl,userUpDate) values (#{uploadUsername},#{imgUrl},#{userUpDate})")
    boolean save(Img img);

    @Select("select * from img")
    List<Img> findAll();
}
