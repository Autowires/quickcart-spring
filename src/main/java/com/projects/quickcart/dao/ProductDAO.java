package com.projects.quickcart.dao;

import com.projects.quickcart.entity.Products;

public interface ProductDAO {
	
	boolean addProduct(Long id, Products product);

}
