package com.projects.quickcart.service;

import java.util.List;

import com.projects.quickcart.entity.CartItem;
import com.projects.quickcart.entity.Product;

public interface CustomerService {
	List<Product> getItems(long userId);

	void addWishlistItem(long userId, long productId);

	void removeWishlistItem(long userId, long productId);

	List<CartItem> getCartItemsByCustomer(long userId);

	void addProductToCart(long userId, long productId);

	void updateCartQuantity(long userId, long productId, int quantity);
}
