package com.shoppingcart.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.app.entity.OrderItem;

@Repository("orderitemRepository")
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
	OrderItem findById(int id);
	
}
