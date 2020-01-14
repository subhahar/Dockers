package com.shoppingcart.app.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.app.entity.OrderItem;
import com.shoppingcart.app.entity.Product;
import com.shoppingcart.app.exception.ServiceException;
import com.shoppingcart.app.model.OrderProduct;
import com.shoppingcart.app.repository.OrderItemRepository;
import com.shoppingcart.app.repository.ProductRepository;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {
	private static final Logger LOGGER = LogManager.getLogger(ProductServiceImpl.class);
	@Autowired
	ProductRepository productRepository;
	@Autowired
	OrderItemRepository orderitemRepository;

	@Override
	public List<OrderItem> getOrderItems(List<OrderProduct> OrderProducts) {
		// TODO Auto-generated method stub
		LOGGER.info("Update the Cart Item in Order data Entity with quantity");
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		for (OrderProduct orderProduct : OrderProducts) {
			if (orderProduct.getQuantity() != 0) {
				Product product = findById(orderProduct.getId());
				OrderItem orderItem = new OrderItem();
				orderItem.setProduct(product);
				orderItem.setQuantity(orderProduct.getQuantity());
				orderItem = orderitemRepository.save(orderItem);
				orderItems.add(orderItem);
				LOGGER.info("Ordert item is Saved Successfully");
			}
		}
		return orderItems;
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
	}

	@Override
	public List<Product> getProducts() throws ServiceException {
		return (List<Product>) productRepository.findAll();

	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub

		return productRepository.findById(id);
	}

	@Override
	public Product findByProductName(String productName) {
		// TODO Auto-generated method stub
		return productRepository.findByProductName(productName);
	}

	@Override
	public Product Update(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}

}
