package com.projects.quickcart.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.quickcart.dao.UserDAO;
import com.projects.quickcart.dto.RegistrationForm;
import com.projects.quickcart.entity.Customer;
import com.projects.quickcart.entity.MyUser;
import com.projects.quickcart.entity.Retailer;
import com.projects.quickcart.entity.UserStatus;
import com.projects.quickcart.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;

	@Override
	public Optional<MyUser> getUser(String username, String password) {
		return dao.getUser(username, password);
	}

	@Override
	public void registerCustomer(RegistrationForm registrationForm) {
		Customer customer = new Customer();
		customer.setUsername(registrationForm.getUsername());
		customer.setEmail(registrationForm.getEmail());
		customer.setPassword(registrationForm.getPassword());
		customer.setStatus(UserStatus.ACTIVE);
		dao.addCustomer(customer);
	}

	@Override
	public void registerRetailer(RegistrationForm registrationForm) {
		Retailer retailer = new Retailer();
		retailer.setEmail(registrationForm.getEmail());
		retailer.setUsername(registrationForm.getUsername());
		retailer.setPassword(registrationForm.getPassword());
		retailer.setStatus(UserStatus.PENDING_VERIFICATION);
		dao.addRetailer(retailer);
	}

}
