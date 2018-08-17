package com.demo.myapp.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.demo.myapp.model.User;

@ActiveProfiles("test")
@ContextConfiguration("classpath:dispatcher-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
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

		user.setId(ID);
		user.setFullName("name changed");
		
		User updateUser = userDao.updateUser(user);
		
		assertNotNull(updateUser);
		assertEquals(user, updateUser);
	}

	@Test
	public void testGetUserById() {

		User user1 = userDao.getUser(ID);
		System.out.println("Get User By Id: " + user1.toString());
		assertNotNull(user1);
	}

	@Test
	public void testDeleteUser() {

		// Delete user of different id
		userDao.deleteUser(2L);
		
	}
}
