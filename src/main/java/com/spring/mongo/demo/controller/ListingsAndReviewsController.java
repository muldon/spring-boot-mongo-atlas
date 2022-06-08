package com.spring.mongo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongo.demo.model.ListingsAndReviews;
import com.spring.mongo.demo.service.ListingsAndReviewsQueryService;
import com.spring.mongo.demo.service.ListingsAndReviewsService;

@RestController
@RequestMapping("/listingsAndReviews")
public class ListingsAndReviewsController {

    @Autowired
    private ListingsAndReviewsQueryService listingAndReviewsQueryService;
    
    @Autowired
    private ListingsAndReviewsService listingsAndReviewsService;

    @GetMapping
    public List<ListingsAndReviews> getAll() {
        return listingsAndReviewsService.getAll();
    }


    // getAll listing and reviews by name like
    @GetMapping("/name/{name}")
    public List<ListingsAndReviews> findByNameLike(@PathVariable String name) {
        return listingsAndReviewsService.findByNameLike(name);
    }
    
    // getAll listing and reviews by name like case insensitive
    @GetMapping("/name/i/{name}")
    public List<ListingsAndReviews> findByNameLikeInsensitive(@PathVariable String name) {
        return listingAndReviewsQueryService.findByNameLikeInsensitive(name);
    }
      
    @PostMapping("/search")
    public List<ListingsAndReviews> findByConditions(@RequestBody ListingsAndReviews to) {
        return listingAndReviewsQueryService.findByConditions(to);
    }
    
}
