package com.projects.quickcart.dao;

import java.util.List;

import com.projects.quickcart.entity.Product;
import com.projects.quickcart.entity.WishList;

public interface WishlistDAO {

	void addWishlistItem(long userId, long productId);

	void removeWishlistItem(WishList wList);

	List<Product> getItems(long userId);

}
