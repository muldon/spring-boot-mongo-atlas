package com.spring.mongo.demo.service;

import java.util.List;

import com.spring.mongo.demo.model.ListingsAndReviews;

public interface ListingsAndReviewsQueryService {
	
	List<ListingsAndReviews> getAll();

	List<ListingsAndReviews> findByNameLikeInsensitive(String name);

	List<ListingsAndReviews> findByConditions(ListingsAndReviews to);

	 

}
