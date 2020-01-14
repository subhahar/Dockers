package com.shoppingcart.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.app.exception.ServiceException;
import com.shoppingcart.app.request.UserRQ;
import com.shoppingcart.app.service.UserService;

@RestController
public class UserController {
	private static final Logger LOGGER = LogManager.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = "application/json")
	public void addUser(@RequestBody UserRQ userRQ) throws ServiceException {
		LOGGER.info("User Controller : Add the User information - call:/addUser");
		userService.createUser(userRQ);
	}

}
