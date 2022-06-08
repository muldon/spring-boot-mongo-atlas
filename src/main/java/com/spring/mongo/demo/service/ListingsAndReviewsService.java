package com.spring.mongo.demo.service;


import java.util.List;

import com.spring.mongo.demo.model.ListingsAndReviews;

public interface ListingsAndReviewsService {
	
	List<ListingsAndReviews> getAll();
	 
	ListingsAndReviews save(ListingsAndReviews employee);
 
	List<ListingsAndReviews> findByNameLike(String firstName);

	void deleteByName(String name);

	 


}
