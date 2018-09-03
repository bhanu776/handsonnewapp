package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserDao {

	@Autowired
	UserRepository userRepository;
	
	public User saveUser(User user){
		return userRepository.save(user);
	}
	
	public List<User> getUserList(){
		return (List<User>) userRepository.findAll();
	}
	
	public User getUser(long child_id){
		Optional<User> user = userRepository.findById(child_id);
		if(user.isPresent())
			return user.get();
		return null;
	}
	
	public String getRole(String userName,String password){
		User user = userRepository.isValidUser(userName, password);
		if(user != null)
			return user.getRole();
		else
			return null;
	}
}
