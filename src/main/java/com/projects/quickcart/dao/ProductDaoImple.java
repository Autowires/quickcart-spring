package com.projects.quickcart.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projects.quickcart.entity.Product;

@Repository
public class ProductDaoImple implements ProductDAO {

	@Autowired
	private SessionFactory sf;

	@Override
	public List<Product> allProducts() {

		Session ss = sf.openSession();
		Transaction t = ss.beginTransaction();
		Query query = ss.createQuery("from Product");
		List<Product> productList = query.getResultList();
		System.out.println("Product List" + productList);
		return productList;
	}

}
