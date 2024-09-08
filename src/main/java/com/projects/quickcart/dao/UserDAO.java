package com.projects.quickcart.dao;

import java.util.Optional;

import com.projects.quickcart.entity.MyUser;

public interface UserDAO {
	Optional<MyUser> getUser(String username, String password);
}
