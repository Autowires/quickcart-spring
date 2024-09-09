package com.projects.quickcart.dao;

import java.util.List;

import com.projects.quickcart.dto.ProductForm;
import com.projects.quickcart.entity.Product;

public interface ProductDAO {
	List<Product> allProducts();

	Product getProductById(int productId);

	List<Product> findProduct(String category);

	List<Product> getRetailerProducts(long id);

	void addProduct(ProductForm form, Long id);

	Product addRetailerProduct(Long userId, long id);
}
