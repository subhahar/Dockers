package com.shoppingcart.app.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.app.converter.CartVoConverter;
import com.shoppingcart.app.entity.Cart;
import com.shoppingcart.app.entity.OrderItem;
import com.shoppingcart.app.entity.User;
import com.shoppingcart.app.exception.ServiceException;
import com.shoppingcart.app.model.OrderProduct;
import com.shoppingcart.app.repository.CartRepository;
import com.shoppingcart.app.request.CartRQ;

@Service("cartService")
@Transactional
public class CartServiceImpl implements CartService {
	private static final Logger LOGGER = LogManager.getLogger(CartServiceImpl.class);
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	@Autowired
	private CartVoConverter cartVoConverter;

	@Override
	public void processOrder(CartRQ cartRQ) throws ServiceException {
		// TODO Auto-generated method stub
		LOGGER.info("Process the Add to Cart");
		Cart cart = cartRepository.findByUser(getUser(cartRQ.getEmailId()));
		if (cart == null) {
			LOGGER.info("New product is added to the cart");
			cart = new Cart();
			if (cartRQ != null) {
				if (cartRQ.getEmailId() != null) {
					cart.setUser(getUser(cartRQ.getEmailId()));
				}
			}
			List<OrderItem> orderItems = productService.getOrderItems(cartRQ.getProducts());
			cart.setOrderItem(orderItems);
			cart.setTotalamount(getCartPrice(orderItems));
			System.out.println("Save Cart");
			cartRepository.save(cart);
			LOGGER.info("Success fully Added New item in the Cart");
		} else if (cart != null) {
			List<OrderItem> orderItemsUpdate = userOrderUpdate(cartRQ, cart);
			if (orderItemsUpdate != null) {
				cart.setOrderItem(orderItemsUpdate);
				cart.setTotalamount(getCartPrice(orderItemsUpdate));
				cartRepository.save(cart);
				LOGGER.info("Success fully Updated the item in the Cart");
			}
		}

	}

	@Override
	public Cart getOrderDetailsByUserID(CartRQ cartRQ) throws ServiceException {
		LOGGER.info("Success fully Retrive the information of the cart");
		return cartRepository.findByUser(getUser(cartRQ.getEmailId()));
	}

	private User getUser(String emailID) throws ServiceException {

		if (emailID != null & userService.getUserDetailByEmailID(emailID) != null) {
			return userService.getUserDetailByEmailID(emailID);
		}
		return null;
	}

	private Cart getCart(CartRQ cartRQ) throws ServiceException {
		Cart cart = null;
		if (cartRQ != null && cartRQ.getEmailId() != null) {
			return cartRepository.findByUser(getUser(cartRQ.getEmailId()));
		}
		return cart;
	}

	private List<OrderItem> userOrderUpdate(CartRQ cartRQ, Cart cart) throws ServiceException {
		List<OrderItem> orderItemsUpdate = new ArrayList<OrderItem>();
		if (cart != null) {
			List<OrderItem> orderItems = cart.getOrderItem();
			List<OrderProduct> orderProducts = cartRQ.getProducts();
			for (OrderItem orderItem : orderItems) {
				for (OrderProduct productRQ : orderProducts) {
					if (cartVoConverter.convertVOProduct(productRQ, orderItem) != null) {
						orderItemsUpdate.add(cartVoConverter.convertVOProduct(productRQ, orderItem));
					}
				}
			}
		}
		return orderItemsUpdate;

	}

	private double getCartPrice(List<OrderItem> orderItems) throws ServiceException {
		double price = 0.0;
		int quantity = 0;
		double total = 0.0;
		for (OrderItem orderItem : orderItems) {
			price = orderItem.getProduct().getPrice();
			if (orderItem.getQuantity() <= 0) {
				LOGGER.error("Quantity should not be negative");
				throw new ServiceException();
			}
			quantity = orderItem.getQuantity();
			total = total + (price * quantity);

		}
		return total;
	}

	@Override
	public void addCart(Cart cart) throws ServiceException{
		// TODO Auto-generated method stub
		cart = cartRepository.save(cart);
		if(cart !=null) {
			LOGGER.info("Updated Cart information");
		}
	}

	@Override
	public List<Cart> getCarts() throws ServiceException{
		// TODO Auto-generated method stub
		LOGGER.info("get all the Carts ");
		return (List<Cart>) cartRepository.findAll();
	}

	@Override
	public Cart findById(int id) throws ServiceException{
		// TODO Auto-generated method stub
		LOGGER.info("get Cart information by id");
		return cartRepository.findById(id);
	}

	@Override
	public Cart Update(Cart cart) throws ServiceException{
		// TODO Auto-generated method stub
		cart = cartRepository.save(cart);
		if(cart !=null) {
			LOGGER.info("Updated Cart information");
		}
		return cart;
		
	}

	@Override
	public void deleteCartById(int id)  throws ServiceException {
		// TODO Auto-generated method stub
		cartRepository.deleteById(id);
		LOGGER.info("Success full removal of Cart by id"+id);
	}

	@Override
	public void removeCart(CartRQ cartRQ) throws ServiceException {
		// TODO Auto-generated method stub
		 Cart cart = getCart(cartRQ);
		 if(cart!=null & cart.getId() != 0) {
			 cartRepository.deleteById(cart.getId());
		 }
		 LOGGER.info("Success full removal of Cart");
	}

}
