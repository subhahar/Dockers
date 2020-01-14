package com.shoppingcart.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.app.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
	User findById(int id);
	User findByEmailId(String emailId);
}
