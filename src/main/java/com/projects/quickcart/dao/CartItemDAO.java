package com.projects.quickcart.dao;

import java.util.List;

import com.projects.quickcart.entity.CartItem;
import com.projects.quickcart.entity.Product;

public interface CartItemDAO {
	void addItem(long cutomerId, long productId);

	void removeItem(long cutomerId, long productId);

	List<Product> getCartProducts(long customerId);

	void updateitemQuantity(long customerId, long productId, long quanitiy);

	List<CartItem> getCartItems(long userId);
}
