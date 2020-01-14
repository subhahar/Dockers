package com.shoppingcart.app.converter;

import com.shoppingcart.app.entity.OrderItem;
import com.shoppingcart.app.exception.ServiceException;
import com.shoppingcart.app.model.OrderProduct;

public interface CartVoConverter {

	public OrderItem convertVOProduct(OrderProduct productRQ, OrderItem OrderItem) throws ServiceException;
}
