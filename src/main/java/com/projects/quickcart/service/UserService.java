package com.projects.quickcart.service;

import java.util.Optional;

import com.projects.quickcart.dto.RegistrationForm;
import com.projects.quickcart.entity.MyUser;

public interface UserService {
	Optional<MyUser> getUser(String username, String password);

	void registerCustomer(RegistrationForm registrationForm);

	void registerRetailer(RegistrationForm registrationForm);
}
