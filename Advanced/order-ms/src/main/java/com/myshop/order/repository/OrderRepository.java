package com.myshop.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myshop.order.model.Order;

public interface OrderRepository extends MongoRepository<Order,Integer> {
	   public Order findByOrderId(String orderId);
}
