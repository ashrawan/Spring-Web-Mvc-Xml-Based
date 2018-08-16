package com.demo.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.myapp.dao.UserDao;
import com.demo.myapp.model.User;

@Service
public class UserServiceImpl implements UserService {

	private final UserDao userDao;

	
	public UserServiceImpl(final UserDao userDao) {
		this.userDao = userDao;
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public User addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public User getUser(long id) {
		return userDao.getUser(id);
	}

	@Override
	public User updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public void deleteUser(long id) throws Exception {
		if (userDao.getUser(id) == null) {
			throw new Exception("user not found");
		}
		userDao.deleteUser(id);
	}

}
