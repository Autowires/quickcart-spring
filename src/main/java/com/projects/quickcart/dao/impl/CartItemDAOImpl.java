package com.projects.quickcart.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projects.quickcart.dao.CartItemDAO;
import com.projects.quickcart.entity.CartItem;
import com.projects.quickcart.entity.CartItem.CartItemId;

import jakarta.transaction.Transactional;

@Repository
public class CartItemDAOImpl implements CartItemDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addItem(long cutomerId, long productId) {
		sessionFactory.inTransaction(session -> {
			CartItem cartItem = new CartItem();
			CartItemId id = new CartItemId();
			id.setCustomerId(cutomerId);
			id.setProductId(productId);
			cartItem.setId(id);
			session.persist(cartItem);
		});

	}

	@Override
	public void removeItem(long cutomerId, long productId) {
		sessionFactory.inTransaction(session -> {
			var query = session
					.createMutationQuery("delete from CartItem c where c.customer.id = :cid and c.product.id = :pid");
			query.setParameter("cid", cutomerId);
			query.setParameter("pid", productId);
			query.executeUpdate();
		});
	}

	@Override
	@Transactional
	public List<CartItem> getCartItems(long userId) {
		return sessionFactory.fromTransaction(session -> {
			var query = session.createSelectionQuery("from CartItem c where c.customer.id = :id", CartItem.class);
			query.setParameter("id", userId);
			return query.getResultList();
		});
	}

	@Override
	public void update(CartItem item) {
		sessionFactory.inTransaction(session -> {
			session.merge(item);
		});
	}

}
