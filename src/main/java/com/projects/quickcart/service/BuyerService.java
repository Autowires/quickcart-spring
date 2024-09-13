package com.projects.quickcart.service;

import java.util.List;

import com.projects.quickcart.entity.Product;

public interface BuyerService {
	List<Product> getProducts(String category);

	Product getProduct(long id);

	boolean isProductWishlisted(Long id1, long id);

	boolean isProductInCart(Long id1, long id);

}
