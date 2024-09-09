package com.projects.quickcart.dao;

import java.util.List;

import com.projects.quickcart.dto.ProductForm;
import com.projects.quickcart.entity.Product;

public interface ProductDAO {
	List<Product> allProducts();

	Product getProductById(long id);

	List<Product> findProduct(String category);

	List<Product> getRetailerProducts(long id);

	void addProduct(ProductForm form, Long id);

	Product addRetailerProduct(Long userId, long id);

	int updateProduct(Long userId, long id, ProductForm form);

	void deleteProduct(long userId, long id);
}
