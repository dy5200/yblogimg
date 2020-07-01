package com.thlly.service.impl;

import com.thlly.dao.UserDao;
import com.thlly.domain.User;
import com.thlly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public boolean register(User user) {
        if(userDao.findByUsername(user.getUsername())!=null){
            return false;
        } else{
            return userDao.save(user);
        }
    }

    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user);
    }
}
