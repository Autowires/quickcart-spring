package com.projects.quickcart.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.projects.quickcart.dao.WishlistDAO;
import com.projects.quickcart.entity.Product;
import com.projects.quickcart.entity.WishList;
import com.projects.quickcart.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	// TODO: don't forget to add AutoWired
	private WishlistDAO wishlistDAO; // TODO: you must have implementation of this DAO;

	@Override
	public List<Product> getItems(long userId) {
		List<Product> products = new LinkedList<>();
		int count = 5;
		while (count-- > 1) {
			Product product = new Product();
			product.setId(count);
			product.setTitle("liked product " + count);
			product.setDescription("it's fake");
			product.setCategory("Not for sale");
			product.setPrice(99.99);
			products.add(product);
		}
		return products;
	}

	@Override
	public void addWishlistItem(long userId, long productId) {
		WishList wList = new WishList();
		wList.setId(productId);
		wList.setId(userId);
		wishlistDAO.addWishlistItem(wList);

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
