package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

	@Query("select u from User u where u.email=?1 and u.password=?2")
	public User isValidUser(String userName,String password);
}
