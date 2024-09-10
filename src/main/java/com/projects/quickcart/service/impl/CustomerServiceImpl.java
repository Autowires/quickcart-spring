package com.projects.quickcart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.quickcart.dao.WishlistDAO;
import com.projects.quickcart.entity.Product;
import com.projects.quickcart.entity.WishList;
import com.projects.quickcart.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private WishlistDAO wishlistDAO; 
	
	@Override
	public List<Product> getItems(long userId) {
		return wishlistDAO.getItems(userId);

	}

	@Override
	public void addWishlistItem(long userId, long productId) {
		wishlistDAO.addWishlistItem(userId, productId);
	}

	@Override
	public void removeWishlistItem(long userId, long productId) {
		// TODO remove product from wish list
		WishList wList = new WishList();
		wList.setId(productId);
		wList.setId(userId);
		if (wList != null)
			wishlistDAO.removeWishlistItem(wList);
	}

}
