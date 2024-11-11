package com.rahul.movies.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
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

	public Optional<Movie> movieById(String imdbId) {
		return movieRepository.findMovieByImdbId(imdbId);
	}
}
