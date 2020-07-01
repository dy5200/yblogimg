package com.thlly.service;

import com.thlly.domain.User;

public interface UserService {
    boolean register(User user);

    User login(User user);
}
