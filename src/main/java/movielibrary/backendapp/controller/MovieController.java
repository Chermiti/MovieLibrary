package movielibrary.backendapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import movielibrary.backendapp.model.Movie;
import movielibrary.backendapp.service.MovieService;

import java.util.List;
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false"    )
@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@GetMapping("/movies")
	public ResponseEntity<List<Movie>> getAllMovies(){
		return ResponseEntity.ok().body(movieService.getAllMovies());
	}
	
	@PostMapping("/movies")
	public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
		return ResponseEntity.ok().body(this.movieService.createMovie(movie));
	}
	
	@PutMapping("/movies/{id}")
	public ResponseEntity<Movie> updateMovie(@PathVariable long id, @RequestBody Movie movie){
		movie.setId(id);
		return ResponseEntity.ok().body(this.movieService.updateMovie(movie));
	}
	
	@DeleteMapping("/movies/{id}")
	public HttpStatus deleteMovie(@PathVariable long id){
		this.movieService.deleteMovie(id);
		return HttpStatus.OK;
	}
	
	@GetMapping("/movies/{id}")
	public ResponseEntity<Movie> getMovieByID(@PathVariable long id){
		return ResponseEntity.ok().body(this.movieService.getMovieById(id));
	}
}
