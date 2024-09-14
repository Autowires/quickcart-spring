package com.projects.quickcart.service;

import java.util.List;

import com.projects.quickcart.entity.OrderDetail;
import com.projects.quickcart.entity.OrderStatus;

public interface RetailerService {

	List<OrderDetail> getOrders(long userId, OrderStatus status);

}
