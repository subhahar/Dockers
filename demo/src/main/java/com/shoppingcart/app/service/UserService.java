package com.shoppingcart.app.service;

import com.shoppingcart.app.exception.ServiceException;
import com.shoppingcart.app.request.UserRQ;

public interface UserService {

	public void createUser(UserRQ userRQ) throws ServiceException;

	public com.shoppingcart.app.entity.User getUserDetailByEmailID(String emailID) throws ServiceException;

}
