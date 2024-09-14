package com.projects.quickcart.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.projects.quickcart.dao.OrderDetailDAO;
import com.projects.quickcart.entity.OrderDetail;
import com.projects.quickcart.entity.OrderStatus;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class OrderDetailDAOImpl implements OrderDetailDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<OrderDetail> getRetailerOrderDetails(long userId, OrderStatus status) {
		StringBuilder queryBuilder = new StringBuilder(
				"SELECT od FROM OrderDetail od JOIN od.product p WHERE p.retailer.id = :userId");

		if (status != null) {
			queryBuilder.append(" AND od.orderStatus = :status");
		}

		var query = entityManager.createQuery(queryBuilder.toString(), OrderDetail.class);
		query.setParameter("userId", userId);

		if (status != null) {
			query.setParameter("status", status);
		}

		return query.getResultList();
	}

}
