package com.shoppingcart.app.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.app.entity.Product;
import com.shoppingcart.app.exception.ServiceException;
import com.shoppingcart.app.service.ProductService;

@RestController
public class ProductController {
	private static final Logger LOGGER = LogManager.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/products", method = RequestMethod.GET, produces = "application/json")
	public List<Product> getProducts() throws ServiceException {
		LOGGER.info("ShoppingCartApplication: Get the information of the List of Products - Call : /products");
		 return productService.getProducts();
	}

}
