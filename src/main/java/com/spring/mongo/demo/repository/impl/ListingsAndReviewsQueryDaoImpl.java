package com.spring.mongo.demo.repository.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.spring.mongo.demo.model.ListingsAndReviews;
import com.spring.mongo.demo.repository.ListingsAndReviewsQueryDao;


@Repository
class ListingsAndReviewsQueryDaoImpl implements ListingsAndReviewsQueryDao {


    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<ListingsAndReviews> getAll() {
        System.out.println("Inside ListingsAndReviews Query DAO Impl's get()");
        return mongoTemplate.findAll(ListingsAndReviews.class);
    }

    /*
     * Example using 
     */
	@Override
	public List<ListingsAndReviews> findByNameLikeInsensitive(String name) {
		MongoCollection<Document> coll = mongoTemplate.getCollection("listingsAndReviews");

		List<Bson> pipeline = Arrays.asList(new Document("$match", 
			    new Document("name", Pattern.compile("Charming(?i)"))));
		
		List<Document> result = coll.aggregate(pipeline).into(new ArrayList<Document>());
		List<ListingsAndReviews> result2 = new ArrayList<>();
		result.forEach(doc -> 
			{
				Gson gson = new Gson();
				ListingsAndReviews to = gson.fromJson(doc.toJson(), ListingsAndReviews.class);
				result2.add(to);
			});;
		return result2;
	}

	@Override
	public List<ListingsAndReviews> findByConditions(ListingsAndReviews to) {
		Query query = new Query();
		//Criteria criteria = new Criteria();
		if(!StringUtils.isEmpty(to.getName())) {
			query.addCriteria(Criteria.where("name").regex(to.getName(),"i"));
		}
		if(!StringUtils.isEmpty(to.getSummary())) {
			query.addCriteria(Criteria.where("summary").regex(to.getSummary(),"i"));			
		}
		//criteria.orOperator(Criteria.where("firstName").regex(name,"i"), Criteria.where("lastName").regex(name,"i"));
		
		query.with(Sort.by(Sort.Direction.ASC, "id"));
		return mongoTemplate.find(query, ListingsAndReviews.class);
		 
	}

 


}
