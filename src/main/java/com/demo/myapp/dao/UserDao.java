package com.demo.myapp.dao;

import java.util.List;

import com.demo.myapp.model.User;

public interface UserDao {

    List<User> getAllUsers();
    User addUser(User user);
    User getUser(long id);
    User updateUser(User user);
    void deleteUser(long id);
}
