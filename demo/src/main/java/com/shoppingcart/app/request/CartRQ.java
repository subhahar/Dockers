package com.shoppingcart.app.request;

import java.util.List;

import com.shoppingcart.app.model.OrderProduct;

public class CartRQ {
	private String emailId;
	private List<OrderProduct> products;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public List<OrderProduct> getProducts() {
		return products;
	}

	public void setProducts(List<OrderProduct> products) {
		this.products = products;
	}

}
