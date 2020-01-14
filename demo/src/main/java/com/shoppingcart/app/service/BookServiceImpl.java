package com.shoppingcart.app.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {
	private static final Logger LOGGER = LogManager.getLogger(BookServiceImpl.class);
}
