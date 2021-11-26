package movielibrary.backendapp.service;

import java.util.List;

import movielibrary.backendapp.model.Movie;

public interface MovieService {
	
	Movie createMovie(Movie movie);
	Movie updateMovie(Movie movie);
	List<Movie> getAllMovies();
	void deleteMovie(Long id);
	void createAll(List<Movie> movies);
	Movie getMovieById(Long id);

}
