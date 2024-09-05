package com.projects.quickcart.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projects.quickcart.entity.Products;

@Repository
public class ProductDaoImplementation implements ProductDAO {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public boolean addProduct(Long id, Products product) {
		
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		s.persist(product);
		t.commit();
		return true;
	}

	public List<Products> getProductsByRetailer(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
