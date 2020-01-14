package com.shoppingcart.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication()
public class ShoppingCartApplication extends SpringBootServletInitializer implements WebApplicationInitializer {
	private static final Logger LOGGER = LogManager.getLogger(ShoppingCartApplication.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ShoppingCartApplication.class);
	}

	public static void main(String[] args) {
		LOGGER.info(" ShoppingCartApplication Start ");
		SpringApplication.run(ShoppingCartApplication.class, args);
		LOGGER.info(" ShoppingCartApplication End ");
	}
}
