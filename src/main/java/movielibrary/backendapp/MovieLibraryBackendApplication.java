package movielibrary.backendapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

import movielibrary.backendapp.model.Movie;
import movielibrary.backendapp.service.MoviesServiceImpl;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
public class MovieLibraryBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieLibraryBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(MoviesServiceImpl moviesServiceImpl) {
		return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Movie>> typeReference = new TypeReference<List<Movie>>() {
			};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/movies.json");
			try {
				List<Movie> movies = mapper.readValue(inputStream, typeReference);
				moviesServiceImpl.createAll(movies);
				System.out.println("Movies Saved!");
			} catch (IOException e) {
				System.out.println("Unable to save movies: " + e.getMessage());
			}
		};
	}

}
