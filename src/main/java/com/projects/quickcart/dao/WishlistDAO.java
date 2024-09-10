package com.projects.quickcart.dao;

import com.projects.quickcart.entity.WishList;

public interface WishlistDAO {

	void addWishlistItem(WishList wList);

	void removeWishlistItem(WishList wList);

}
