package com.thlly.dao;

import com.thlly.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Insert("insert into user(username,password,email,type) values (#{username},#{password},#{email},'user')")
    boolean save(User user);

    @Select("select * from user where username=#{username}")
    User findByUsername(String username);

    @Select("select * from user where username=#{username} and password=#{password}")
    User findByUsernameAndPassword(User user);
}
