package com.myshop.order.service;

import java.util.List;

import com.myshop.order.model.CartItem;
import com.myshop.order.model.Order;

public interface OrderService {

//	    public Order placeOrder(List<CartItem> cartItems);
//	    public Order getOrderDetails(String orderId);
//	    public void updateOrderDetails(String orderId,String status);
//	    public void cancelOrder(String orderId);

	public Order placeOrder(List<CartItem> cartItems);

	public Order getOrderDetails(String orderId);
	public List<Order> getAllOrders();

}
