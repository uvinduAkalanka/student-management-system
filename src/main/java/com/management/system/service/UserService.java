package com.management.system.service;

import com.management.system.model.User;

import java.util.List;

public interface UserService {
    User login(String userName, String password);

    User fetchUserByEmail(String userName);

    List<User> getAllStudent();


}
