package com.demo.myapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.myapp.model.User;
import com.demo.myapp.service.UserService;

@RestController
public class UserController {

	private UserService userService;

	public UserController(final UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> retrieveAllUsers() {

		List<User> userList = userService.getAllUsers();
		if (userList == null || userList.size() == 0) {
			return new ResponseEntity(userList, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable long id) {

		User user = userService.getUser(id);
		if (user == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {

		User userRe = userService.addUser(user);
		if (userRe == null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<User>(userRe, HttpStatus.OK);

	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable long id) {
		user.setId(id);
		User u = userService.updateUser(user);
		if (u == null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<User>(u, HttpStatus.OK);

	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity deleteUser(@PathVariable int id) {

		try {
			userService.deleteUser(id);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.CONFLICT);
		}

		return new ResponseEntity(HttpStatus.OK);
	}

}