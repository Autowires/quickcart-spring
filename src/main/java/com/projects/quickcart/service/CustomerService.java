package com.projects.quickcart.service;

import java.util.List;

import com.projects.quickcart.entity.Product;

public interface CustomerService {
	List<Product> getItems(long userId);

	void addWishlistItem(long userId, long productId);

	void removeWishlistItem(long userId, long productId);
}
