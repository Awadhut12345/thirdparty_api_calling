package com.in.irise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.irise.entity.User;
import com.in.irise.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User createUserService(User user) {
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User getUserByIdService(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public String deleteUserByIdService(Long id) {
		 userRepository.deleteById(id);
		return "User delete successfully";
	}
	
	public User updateUserById(User user, Long id) {
		User save = userRepository.save(user);
		user.setUserId(user.getUserId());
		user.setId(user.getId());
		user.setTitle(user.getTitle());
		user.setBody(user.getBody());
		return save;
	}

}
