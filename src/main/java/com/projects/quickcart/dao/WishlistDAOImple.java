package com.projects.quickcart.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projects.quickcart.entity.WishList;

@Repository
public class WishlistDAOImple implements WishlistDAO {

	@Autowired
	private SessionFactory sf;

	@Override
	public void addWishlistItem(WishList wList) {
		Session ss = sf.openSession();
		Transaction t = ss.beginTransaction();
		ss.save(wList);

	}

	public void removeWishlistItem(WishList wList) {
		Session ss = sf.openSession();
		Transaction t = ss.beginTransaction();
		ss.delete(wList);

	}

}
