package com.demo.myapp.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.demo.myapp.model.User;

@ActiveProfiles("test")
@ContextConfiguration("classpath:dispatcher-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TestUserDao {

	@Autowired
	private UserDao userDao;

	private User user = new User();

	private static final long ID = 1;

	@Before
	public void setUp() {
		user.setFullName("test name");
		user.setStatus(1);
	}

	@Test
	public void testSaveUser() {

		User savedUser = userDao.addUser(user);
		assertNotNull(savedUser);
		assertEquals(user, savedUser);
	}

	@Test
	public void testUpdateUser() {
		
		User savedUser = userDao.addUser(user);
		savedUser.setFullName("name changed");		
		User updateUser = userDao.updateUser(user);
		assertNotNull(updateUser);
	}

	@Test
	public void testGetUserById() {

		User savedUser = userDao.addUser(user);
		User user1 = userDao.getUser(savedUser.getId());
		assertNotNull(user1);
	}

	@Test
	public void testDeleteUser() {
		
		User savedUser = userDao.addUser(user);
		userDao.deleteUser(savedUser.getId());
		assertNull(userDao.getUser(savedUser.getId()));
	}
		
		
}
