package movielibrary.backendapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movielibrary.backendapp.Exception.ResourceNotFoundException;
import movielibrary.backendapp.model.Movie;
import movielibrary.backendapp.repository.MovieRepository;
@Service
public class MoviesServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Movie createMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	@Override
	public Movie updateMovie(Movie movie) {
		Optional<Movie> getMovie = this.movieRepository.findById(movie.getId());
		
		if(getMovie.isPresent()) {
			Movie updatedMovie = getMovie.get();
			updatedMovie.setId(movie.getId());
			updatedMovie.setTitle(movie.getTitle());
			updatedMovie.setDirector(movie.getDirector());
			updatedMovie.setReleaseDate(movie.getReleaseDate());
			updatedMovie.setType(movie.getType());
			movieRepository.save(updatedMovie);
			return updatedMovie;
		}else {
			throw new ResourceNotFoundException("Movie not found with id : " + movie.getId());
		}
	}

	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public void deleteMovie(Long id) {
		Optional<Movie> getMovie = this.movieRepository.findById(id);
		if(getMovie.isPresent()) {
			this.movieRepository.delete(getMovie.get());
		}else {
			throw new ResourceNotFoundException("Movie not found with id : " + id);
		}
	}

	@Override
	public void createAll(List<Movie> movies) {
		movieRepository.saveAll(movies);
		
	}

	@Override
	public Movie getMovieById(Long id) {
		// TODO Auto-generated method stub
		Optional<Movie> getMovie = this.movieRepository.findById(id);
		if(getMovie.isPresent()) {
			Movie movie = getMovie.get();
			return movie;
		}else {
			throw new ResourceNotFoundException("Movie not found with id : " + id);
		}
	}

}
