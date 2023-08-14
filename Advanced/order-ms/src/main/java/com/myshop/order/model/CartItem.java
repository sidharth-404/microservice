package com.myshop.order.model;

import lombok.Data;

@Data
public class CartItem {

	private int cartId;
	private String productId;
	private int quantity;
	private float totalPrice;
	
}
