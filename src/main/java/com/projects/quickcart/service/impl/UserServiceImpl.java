package com.projects.quickcart.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.quickcart.dao.UserDAO;
import com.projects.quickcart.entity.MyUser;
import com.projects.quickcart.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;

	@Override
	public Optional<MyUser> getUser(String username, String password) {
		return dao.getUser(username, password);
	}

}
