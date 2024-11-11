package com.rahul.movies.service;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.rahul.movies.model.Movie;
import com.rahul.movies.model.Review;
import com.rahul.movies.repository.ReviewRepository;

@Service
public class ReviewService {

	private ReviewRepository reviewRepository;
	private MongoTemplate mongoTemplate;
	
	public ReviewService(ReviewRepository reviewRepository, MongoTemplate mongoTemplate) {
		
		this.reviewRepository = reviewRepository;
		this.mongoTemplate = mongoTemplate;
	}
	
	public Review createReview(String reviewBody, String imdbId) {
		
		Review review = reviewRepository.insert(new Review(reviewBody));
		mongoTemplate.update(Movie.class)
					.matching(Criteria.where("imdbId").is(imdbId))
					.apply(new Update().push("reviewIds").value(review))
					.first();
		return review;
	}
}
