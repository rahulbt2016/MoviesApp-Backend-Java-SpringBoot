package com.rahul.movies.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.movies.model.Review;
import com.rahul.movies.service.ReviewService;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
	
	private ReviewService reviewService;
	
	public ReviewController(ReviewService reviewService) {
		
		this.reviewService = reviewService;
	}
	
	@PostMapping
	public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
		
		return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);
	}
	
}
