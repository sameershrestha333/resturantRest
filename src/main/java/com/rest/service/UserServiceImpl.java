package com.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.dao.UserDAO;
import com.rest.model.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public Object findAll() {
		// TODO Auto-generated method stub
		return  userDAO.findAll();
	}

	@Override
	public User findById(long id) {
		// TODO Auto-generated method stub
		return userDAO.findOne(id);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userDAO.findByEmail(email);
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userDAO.save(user);
	}

	@Override
	public void delete(User user) {
		userDAO.delete(user);
	}

}
