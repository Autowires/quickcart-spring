package com.projects.quickcart.dao;

import java.util.List;

import com.projects.quickcart.entity.ProductReview;

public interface ProductReviewDAO {

	void save(ProductReview productReview);

	ProductReview findById(long id);

	List<ProductReview> findAll();

	void update(ProductReview productReview);

	void delete(ProductReview productReview);

	List<ProductReview> findByProductId(long productId);
}
