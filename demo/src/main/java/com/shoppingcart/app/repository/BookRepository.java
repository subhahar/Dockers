package com.shoppingcart.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.app.entity.Book;

@Repository("bookRepository")
public interface BookRepository extends JpaRepository<Book, Integer> {

}
