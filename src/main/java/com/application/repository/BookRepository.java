package com.application.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.entity.Bookstore;

@Repository
public interface BookRepository  extends JpaRepository<Bookstore,Integer>{

	Bookstore save(Bookstore product);
}
