package com.shoppingcart.app.converter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.shoppingcart.app.entity.User;
import com.shoppingcart.app.exception.ServiceException;
import com.shoppingcart.app.model.UserOrder;
import com.shoppingcart.app.request.UserRQ;

@Component
public class UserVoConverterImpl implements UserVoConverter {
	private static final Logger LOGGER = LogManager.getLogger(UserVoConverterImpl.class);

	@Override
	public User UserVoConveter(UserRQ userRQ) throws ServiceException{
		// TODO Auto-generated method stub
		LOGGER.info("User details is converted from userRQ to Entity User ");
		User user = new User();
		user.setEmailId(userRQ.getEmailId());
		user.setName(userRQ.getName());
		user.setPassWord(userRQ.getPassWord());
		user.setRole(userRQ.getRole());
		LOGGER.info("Success of User Vo Conversion ");
		return user;
	}

	@Override
	public UserOrder UserOrderVoConveter(User user) throws ServiceException{
		// TODO Auto-generated method stub
		LOGGER.info("User Order details is converted from Entity User to UserOrder ");
		UserOrder userOrder = new UserOrder();
		userOrder.setEmailId(user.getEmailId());
		userOrder.setName(user.getName());
		userOrder.setPassWord(user.getPassWord());
		userOrder.setRole(user.getRole());
		LOGGER.info("Success of User Order Vo Conversion ");
		return userOrder;
	}

}
