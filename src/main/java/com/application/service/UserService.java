package com.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.entity.Bookstore;
import com.application.entity.User;
import com.application.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	public UserRepository userRepository;

	public User saveUser(User user) {
		userRepository.save(user);
		return user;
	}

	public User getProduct(int id) {
		return userRepository.getOne(id);
	}

	public List<User> listAll() {
		return userRepository.findAll();
	}

	public void delete(int id) {
		userRepository.deleteById(id);
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public List<User> getLoginUsernameAndPassword(){
		return userRepository.getUsernameAndPassword();
	}
}
