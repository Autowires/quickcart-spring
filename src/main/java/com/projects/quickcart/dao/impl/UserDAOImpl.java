package com.projects.quickcart.dao.impl;

import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projects.quickcart.dao.UserDAO;
import com.projects.quickcart.entity.MyUser;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Optional<MyUser> getUser(String username, String password) {
		return sessionFactory.fromSession(session -> {
			var query = session.createQuery("from User u where u.username = :username and u.password = :password",
					MyUser.class);
			query.setParameter("username", username);
			query.setParameter("password", password);
			MyUser myUser = query.getSingleResultOrNull();
			if (myUser != null)
				return Optional.of(myUser);
			return Optional.empty();
		});
	}

}
