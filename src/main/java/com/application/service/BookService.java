package com.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.entity.Bookstore;

import com.application.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;

	public List<Bookstore> findAll() {
		return repository.findAll();
	}

	public Bookstore save(Bookstore store) {
		return repository.save(store);
	}

	public Bookstore getProduct(int id) {
		return repository.getOne(id);
	}

	public void delete(int id) {
		repository.deleteById(id);
	}



}
