package com.projects.quickcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.quickcart.dao.ProductReviewDAO;
import com.projects.quickcart.entity.ProductReview;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductReviewServiceImpl implements ProductReviewService {

	@Autowired
	private ProductReviewDAO productReviewDAO;

	@Override
	public void saveProductReview(ProductReview productReview) {

		productReviewDAO.save(productReview);

	}

	@Override
	public ProductReview getProductReviewById(long id) {
		// TODO Auto-generated method stub
		return productReviewDAO.findById(id);
	}

	@Override
	public List<ProductReview> getAllProductReviews() {

		return productReviewDAO.findAll();
	}

	@Override
	public void updateProductReview(ProductReview productReview) {

		productReviewDAO.update(productReview);
	}

	@Override
	public void deleteProductReview(long id) {

		ProductReview productReview = productReviewDAO.findById(id);
		if (productReview != null) {
			productReviewDAO.delete(productReview);
		} else {

		}

	}

	@Override
	public List<ProductReview> getReviewsByProductId(long productId) {

		return productReviewDAO.findByProductId(productId);
	}

}
