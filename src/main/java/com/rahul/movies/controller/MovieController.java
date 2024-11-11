package com.rahul.movies.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.movies.model.Movie;
import com.rahul.movies.service.MovieService;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
	
	private MovieService movieService;
	
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@GetMapping	
	public ResponseEntity<List<Movie>> apiRoot() {
		
		return new ResponseEntity<>(movieService.allMovies(), HttpStatus.OK);
	}
}
