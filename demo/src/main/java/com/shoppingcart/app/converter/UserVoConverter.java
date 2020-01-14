package com.shoppingcart.app.converter;

import com.shoppingcart.app.entity.User;
import com.shoppingcart.app.exception.ServiceException;
import com.shoppingcart.app.model.UserOrder;
import com.shoppingcart.app.request.UserRQ;

public interface UserVoConverter {
	public User UserVoConveter(UserRQ userRQ) throws ServiceException;

	public UserOrder UserOrderVoConveter(User user) throws ServiceException;
}
