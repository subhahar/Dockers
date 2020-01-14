package com.shoppingcart.app.converter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shoppingcart.app.entity.OrderItem;
import com.shoppingcart.app.entity.Product;
import com.shoppingcart.app.exception.ServiceException;
import com.shoppingcart.app.model.OrderProduct;
import com.shoppingcart.app.service.OrderItemService;

@Component("cartVoConverter")
public class CartVoConverterImpl implements CartVoConverter {
	private static final Logger LOGGER = LogManager.getLogger(CartVoConverterImpl.class);
	@Autowired
	private OrderItemService orderItemService;

	

	public OrderItem convertVOProduct(OrderProduct productRQ, OrderItem OrderItem) throws ServiceException{
		LOGGER.info("Cart Vo converter - Convert the product ");
		Product orderProductItem = OrderItem.getProduct();
		if (orderProductItem.getProductId() == productRQ.getId()) {
			if (productRQ.getQuantity() <= 0) {
				LOGGER.info("Validate the prductQuantiry is less than Zero ");
				orderItemService.deleteOrderItemById(OrderItem.getId());
				LOGGER.info("Remove of the product from the cart - Product Id - "+OrderItem.getId());
				return null;
				// To do delete the OrderItem.
			} else if (productRQ.getQuantity() != OrderItem.getQuantity()) {
				// Update the order Item
				LOGGER.info("Update the Quantity of product");
				OrderItem.setQuantity(productRQ.getQuantity());
			}
		}
		LOGGER.info("Cart Vo converter - Successfull Convertion of the order product");
		return OrderItem;
	}
}
