package com.projects.quickcart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.quickcart.dao.ProductDAO;
import com.projects.quickcart.entity.Product;
import com.projects.quickcart.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private ProductDAO dao;

	@Override
	public List<Product> getAllProducts(long retailerId) {
		return dao.getRetailerProducts(retailerId);
	}

}
