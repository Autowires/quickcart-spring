package com.projects.quickcart.dao;

import java.util.Optional;

import com.projects.quickcart.entity.Customer;
import com.projects.quickcart.entity.MyUser;
import com.projects.quickcart.entity.Retailer;

public interface UserDAO {
	Optional<MyUser> getUser(String username, String password);

	void addCustomer(Customer customer);

	void addRetailer(Retailer retailer);
}
