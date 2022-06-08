package com.spring.mongo.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.mongo.demo.model.ListingsAndReviews;

public interface ListingsAndReviewsRepository extends MongoRepository<ListingsAndReviews, String> {

	ListingsAndReviews findByName(String name);

    List<ListingsAndReviews> findByNameLike(String name);
 
	void deleteByNameLike(String name);


}
