package com.shoppingcart.app.service;

import java.util.List;

import com.shoppingcart.app.entity.Cart;
import com.shoppingcart.app.exception.ServiceException;
import com.shoppingcart.app.request.CartRQ;

public interface CartService {

	public void processOrder(CartRQ cartRQ) throws ServiceException;

	public Cart getOrderDetailsByUserID(CartRQ cartRQ) throws ServiceException;

	public void addCart(Cart cart) throws ServiceException;

	public List<Cart> getCarts() throws ServiceException;

	public Cart findById(int id) throws ServiceException;

	public Cart Update(Cart cart) throws ServiceException;

	public void deleteCartById(int id) throws ServiceException;
	public void removeCart(CartRQ cartRQ) throws ServiceException;
}
