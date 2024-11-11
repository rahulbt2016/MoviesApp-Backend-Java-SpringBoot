package com.rahul.movies.service;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.rahul.movies.model.Movie;
import com.rahul.movies.repository.MovieRepository;

@Service
public class MovieService {
	
	private MovieRepository movieRepository;
	
	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	public List<Movie> allMovies() {
		return movieRepository.findAll();
	}
}
