package com.demo.myapp.service;

import java.util.List;

import com.demo.myapp.model.User;

public interface UserService {

    List<User> getAllUsers();
    User addUser(User user);
    User getUser(long id);
    User updateUser(User user);
    void deleteUser(long id) throws Exception;
}
