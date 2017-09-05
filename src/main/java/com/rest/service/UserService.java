package com.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rest.model.User;

public interface UserService {
	// CRUD
	// Retrieve	
	public Object findAll();
	public User findById(long id);
	public User findByEmail(String email);
	// Create
	public User save(User user);

	// Delete
	public void delete(User user);

}
