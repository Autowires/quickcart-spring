package com.projects.quickcart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.quickcart.dao.CartItemDAO;
import com.projects.quickcart.dao.ProductDAO;
import com.projects.quickcart.dao.WishlistDAO;
import com.projects.quickcart.entity.CartItem;
import com.projects.quickcart.entity.Product;
import com.projects.quickcart.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CartItemDAO cartItemDAO;

	@Autowired
	private WishlistDAO wishlistDAO;

	@Autowired
	private ProductDAO productDAO;

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
		wishlistDAO.removeWishlistItem(userId, productId);
	}

	@Override
	public List<CartItem> getCartItemsByCustomer(long userId) {
		return cartItemDAO.getCartItems(userId);
	}

	@Override
	public void addProductToCart(long userId, long productId) {
		cartItemDAO.addItem(userId, productId);
	}

	@Override
	public void updateCartQuantity(long userId, long productId, int quantity) {
		cartItemDAO.updateItem(userId, productId, quantity);
	}

	@Override
	public void deleteCartitem(long userId, long productId) {
		cartItemDAO.removeItem(userId, productId);
	}

	@Override
	public List<Product> getProducts(String category, String search) {
		return productDAO.findProducts(category, search);
	}

	@Override
	public Product getProduct(long id) {
		return productDAO.getProductById(id);
	}

	@Override
	public boolean isProductWishlisted(Long id1, long id) {
		return wishlistDAO.isProductwishlisted(id1, id);
	}

	@Override
	public boolean isProductInCart(Long id1, long id) {
		return cartItemDAO.isProductInCart(id1, id);
	}

	@Override
	public List<String> getCategories() {
		return productDAO.getAllCategories();
	}

}
