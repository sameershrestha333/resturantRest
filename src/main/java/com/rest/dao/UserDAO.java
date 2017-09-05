package com.rest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.model.User;

@Repository
public interface UserDAO extends CrudRepository<User, Long>{
	
	public User findByEmail(String email);

}
