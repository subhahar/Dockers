package com.shoppingcart.app.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("apparalService")
@Transactional
public class ApparalServiceImpl implements ApparalService {
	private static final Logger LOGGER = LogManager.getLogger(ApparalServiceImpl.class);
}
