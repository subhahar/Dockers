package com.shoppingcart.app.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.app.entity.Cart;
import com.shoppingcart.app.exception.ServiceException;
import com.shoppingcart.app.request.CartRQ;
import com.shoppingcart.app.service.CartService;

@RestController
public class ShoppingCartController {
	private static final Logger LOGGER = LogManager.getLogger(ShoppingCartController.class);

	@Autowired
	private CartService cartService;

	@RequestMapping(value = "/addCart", method = RequestMethod.POST, produces = "application/json")
	public void addCart(@RequestBody CartRQ cartRQ) throws ServiceException {
		LOGGER.info("Cart Controller : Add the cart information - call:/addCart");
		cartService.processOrder(cartRQ);
	}

	@RequestMapping(value = "/getCarts", method = RequestMethod.GET, produces = "application/json")
	public List<Cart> getCarts() throws ServiceException {
		LOGGER.info("Cart Controller : get the list of carts - call:/getCarts");
		return cartService.getCarts();
	}

	@RequestMapping(value = "/removeCart", method = RequestMethod.POST, produces = "application/json")
	public void removeCart(@RequestBody CartRQ cartRQ) throws ServiceException {
		LOGGER.info("Cart Controller : get the list of carts - call:/getCarts");
		cartService.removeCart(cartRQ);
		LOGGER.info("Cart Controller : Successfull Remove Cart Tranasction Complete");
	}

}
