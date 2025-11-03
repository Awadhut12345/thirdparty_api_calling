package com.in.irise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.irise.entity.User;
import com.in.irise.service.UserService;

@RestController
@RequestMapping("/user/v1/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/msg")	
	public String getMsg() {
		return "User Service";
	}
	
	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		return userService.createUserService(user);
	}
	
	@GetMapping("/allUsers")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserByIdService(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUserById(@PathVariable Long id) {
		return userService.deleteUserByIdService(id);
	}
	
	@PostMapping("/update/{id}")
	public User updateUserById(@PathVariable Long id, @RequestBody User user) {
		return userService.updateUserById(user, id);
		
	}
	
	
 
}
