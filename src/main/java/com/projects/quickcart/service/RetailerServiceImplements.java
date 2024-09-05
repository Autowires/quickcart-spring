package com.projects.quickcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.quickcart.dao.ProductDaoImplementation;
import com.projects.quickcart.entity.Products;

@Service
public class RetailerServiceImplements implements RetailerService{
   
	@Autowired
	private ProductDaoImplementation pdao;
	
	
	@Override
	public List<Products> getProducts(Long id) {
		
		return pdao.getProductsByRetailer(id);
	}

}
