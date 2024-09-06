package com.projects.quickcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.quickcart.dao.ProductDAO;
import com.projects.quickcart.entity.Product;

@Service
public class BuyerServiceImpl implements BuyerService {

	@Autowired
	private ProductDAO pDao;

	@Override
	public List<Product> getProducts() {
		return pDao.allProducts();
	}

}
