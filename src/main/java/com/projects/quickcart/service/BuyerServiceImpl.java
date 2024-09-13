package com.projects.quickcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.quickcart.dao.CartItemDAO;
import com.projects.quickcart.dao.ProductDAO;
import com.projects.quickcart.dao.WishlistDAO;
import com.projects.quickcart.entity.Product;

@Service
public class BuyerServiceImpl implements BuyerService {

	@Autowired
	private ProductDAO pDao;

	@Autowired
	private WishlistDAO wishlistDAO;

	@Autowired
	private CartItemDAO cartItemDAO;

	@Override
	public List<Product> getProducts(String Category) {
		if (Category == null) {
			return pDao.allProducts();
		} else {
			return pDao.findProduct(Category);
		}
	}

	@Override
	public Product getProduct(long id) {
		return pDao.getProductById(id);
	}

	@Override
	public boolean isProductWishlisted(Long id1, long id) {
		return wishlistDAO.isProductwishlisted(id1, id);
	}

	@Override
	public boolean isProductInCart(Long id1, long id) {
		return cartItemDAO.isProductInCart(id1, id);
	}

}
