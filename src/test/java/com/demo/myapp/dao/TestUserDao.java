package com.demo.myapp.dao;

import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.demo.myapp.model.User;

@ContextConfiguration("classpath:dispatcher-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TestUserDao {

	@Autowired
	private SessionFactory sessionFactory;
	Session session = null;

	private User user = new User();

	private static final long ID = 1;

	@Before
	public void setUp() {
		session = sessionFactory.getCurrentSession();
		user.setFullName("test name");
	}

	@Test
	public void testSaveUser() {
		// saving new User
		long user1 = (long) session.save(user);
		System.out.println("saved User: "+user1);

		assertNotNull(user1);
	}

	@Test
	public void testUpdateUser() {
		// getting users from db
		User user1 = session.get(User.class, ID);
		System.out.println("Existing User: " + user1.toString());

		// setting new values to user
		user1.setFullName("new test");
		session.update(user1);

		// checking updated user
		User updatedUser = session.get(User.class, ID);
		System.out.println("Updated User: " + updatedUser.toString());
		assertNotNull(user1);

	}

	@Test
	public void testGetUserById() {

		// getting users from db
		User user1 = session.get(User.class, ID);
		System.out.println("Get User By Id: " + user1.toString());
		assertNotNull(user1);

	}

	@Test
	public void testDeleteUser() {

		// getting users from db
		User user1 = session.get(User.class, ID);
		session.delete(user1);
		assertNotNull(user1);

	}
}
