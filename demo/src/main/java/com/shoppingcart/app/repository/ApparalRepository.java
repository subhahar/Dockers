package com.shoppingcart.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.app.entity.Apparal;

@Repository("apparalRepository")
public interface ApparalRepository extends JpaRepository<Apparal, Integer> {
}
