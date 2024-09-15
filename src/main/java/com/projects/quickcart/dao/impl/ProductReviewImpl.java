package com.projects.quickcart.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projects.quickcart.dao.ProductReviewDAO;
import com.projects.quickcart.entity.ProductReview;

import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProductReviewImpl implements ProductReviewDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(ProductReview productReview) {

		getCurrentSession().persist(productReview);

	}

	@Override
	public ProductReview findById(long id) {

		return getCurrentSession().get(ProductReview.class, id);
	}

	@Override
	public List<ProductReview> findAll() {

		Query query = getCurrentSession().createQuery("FROM ProductReview", ProductReview.class);
		return query.getResultList();
	}

	@Override
	public void update(ProductReview productReview) {

		getCurrentSession().merge(productReview);

	}

	@Override
	public void delete(ProductReview productReview) {
		// TODO Auto-generated method stub
		Session session = getCurrentSession();

		if (session.contains(productReview)) {
			session.remove(productReview);
		} else {
			session.remove(session.merge(productReview));
		}

	}

	@Override
	public List<ProductReview> findByProductId(long productId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM ProductReview where product.id= :productId", ProductReview.class);
		query.setParameter("productId", productId);
		return query.getResultList();
	}

}
