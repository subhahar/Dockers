package com.shoppingcart.app.service;

import java.util.List;

import com.shoppingcart.app.entity.OrderItem;
import com.shoppingcart.app.entity.Product;
import com.shoppingcart.app.exception.ServiceException;
import com.shoppingcart.app.model.OrderProduct;

public interface ProductService {
	public List<OrderItem> getOrderItems(List<OrderProduct> OrderProducts);
	
	public void addProduct(Product product);

	public List<Product> getProducts() throws ServiceException;

	public Product findById(int id);
	

	public Product findByProductName(String productName);

	public Product Update(Product product);

	public void deleteProductById(int id);
}
