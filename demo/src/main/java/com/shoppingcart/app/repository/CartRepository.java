package com.shoppingcart.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.app.entity.Cart;
import com.shoppingcart.app.entity.User;

/*
 * User can add, update, remove and view the products in the cart. 
 * 
 */
@Repository("cartRepository")
public interface CartRepository extends JpaRepository<Cart, Integer> {
	Cart findById(int id);

	Cart findByUser(User user);
}
