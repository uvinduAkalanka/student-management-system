package com.management.system.service.impl;

import com.management.system.model.User;
import com.management.system.repository.UserRepository;
import com.management.system.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User fetchUserByEmail(String userName) {
        return userRepository.findByUserName(userName).orElseThrow(() -> new RuntimeException(String.format("user not found with the user name : %s", userName)));
    }

    @Override
    public User login(String userName, String password) {
        User user = fetchUserByEmail(userName);

        if (user.getPassword().equals(password)) {
            return user;
        } else {
            throw new RuntimeException("Username or password is incorrect");
        }
    }

    @Override
    public List<User> getAllStudent() {
        return userRepository
                .findAll()
                .stream()
                .filter(user-> Objects.equals(user.getRole(),"student"))
                .collect(Collectors.toList());

    }
}
