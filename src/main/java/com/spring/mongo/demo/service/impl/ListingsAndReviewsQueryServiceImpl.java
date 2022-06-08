package com.spring.mongo.demo.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mongo.demo.model.ListingsAndReviews;
import com.spring.mongo.demo.repository.ListingsAndReviewsQueryDao;
import com.spring.mongo.demo.service.ListingsAndReviewsQueryService;
import org.springframework.util.StringUtils;

@Service
public class ListingsAndReviewsQueryServiceImpl implements ListingsAndReviewsQueryService {

	@Autowired
	private ListingsAndReviewsQueryDao queryDao;

	@Override
	public List<ListingsAndReviews> getAll() {
		System.out.println("Inside ListingsAndReviews Query Service Impl");
		return queryDao.getAll();
	}

	@Override
	public List<ListingsAndReviews> findByNameLikeInsensitive(String name) {
		return queryDao.findByNameLikeInsensitive(name);
	}

	@Override
	public List<ListingsAndReviews> findByConditions(ListingsAndReviews to) {
		return queryDao.findByConditions(to);
	}

	 

}
