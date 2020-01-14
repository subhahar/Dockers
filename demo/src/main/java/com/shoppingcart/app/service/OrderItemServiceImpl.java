package com.shoppingcart.app.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.app.repository.OrderItemRepository;

@Service("orderItemService")
@Transactional
public class OrderItemServiceImpl implements OrderItemService {
	private static final Logger LOGGER = LogManager.getLogger(OrderItemServiceImpl.class);
	@Autowired
	private OrderItemRepository orderitemRepository;

	@Override
	public void deleteOrderItemById(int id) {
		// TODO Auto-generated method stub
		LOGGER.info("Delete the Added Product User Selected.");
		orderitemRepository.deleteById(id);
		LOGGER.info("Successfull Deletion of the  User Selected Product");
	}
}
