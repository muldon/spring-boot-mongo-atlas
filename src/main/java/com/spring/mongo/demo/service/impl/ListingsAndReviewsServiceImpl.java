package com.spring.mongo.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mongo.demo.model.ListingsAndReviews;
import com.spring.mongo.demo.repository.ListingsAndReviewsRepository;
import com.spring.mongo.demo.service.ListingsAndReviewsService;

@Service
public class ListingsAndReviewsServiceImpl implements ListingsAndReviewsService {
	

	@Autowired
	private ListingsAndReviewsRepository repository;
	

	
	@Override
	public List<ListingsAndReviews> getAll() {
		return repository.findAll();
	}
	
	 

	@Override
	public ListingsAndReviews save(ListingsAndReviews employee) {
		return repository.save(employee);
	}

	 
	@Override
	public void deleteByName(String name) {
		repository.deleteByNameLike(name);
		
	}



	@Override
	public List<ListingsAndReviews> findByNameLike(String name) {
		return repository.findByNameLike(name);
	}

	 

}
