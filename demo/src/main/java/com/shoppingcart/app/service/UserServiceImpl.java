package com.shoppingcart.app.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.app.converter.UserVoConverter;
import com.shoppingcart.app.exception.ServiceException;
import com.shoppingcart.app.repository.UserRepository;
import com.shoppingcart.app.request.UserRQ;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserVoConverter userVoConverter;

	@Override
	public void createUser(UserRQ userRQ) throws ServiceException{
		// TODO Auto-generated method stub
		userRepository.save(userVoConverter.UserVoConveter(userRQ));
	}


	@Override
	public com.shoppingcart.app.entity.User getUserDetailByEmailID(String emailID) throws ServiceException {
		return userRepository.findByEmailId(emailID);
	}

	
}
