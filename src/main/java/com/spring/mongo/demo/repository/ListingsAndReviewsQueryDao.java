package com.spring.mongo.demo.repository;

import java.util.List;

import com.spring.mongo.demo.model.ListingsAndReviews;

public interface ListingsAndReviewsQueryDao {
	
	List<ListingsAndReviews> getAll();

	List<ListingsAndReviews> findByNameLikeInsensitive(String name);

	List<ListingsAndReviews> findByConditions(ListingsAndReviews to);

	 

}
