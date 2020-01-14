package com.shoppingcart.app.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.shoppingcart.app.response.CartRS;

@ControllerAdvice
public class CartApplicationErrorController {
	private static final Logger logger = LogManager.getLogger(CartApplicationErrorController.class);

	@ExceptionHandler(ServiceException.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public CartRS processValidationError(ServiceException se) {
		logger.error("Shopping Cart ErrorHandler processValidationError for the Exception");
		CartRS cartRs = new CartRS();
		cartRs.setErrorCode(30050);
		cartRs.setErrorMessage("Service Invalid Data");
		logger.error("Services Exception occurred " + se.getMessage());

		return cartRs;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public CartRS processValidationError(Exception e) {
		CartRS cartRs = new CartRS();
		cartRs.setErrorCode(30040);
		cartRs.setErrorMessage("Invalid Data");
		logger.error("inside process Exceptions error class" + e.getMessage());
		e.printStackTrace();
		return cartRs;
	}
}
