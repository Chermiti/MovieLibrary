package movielibrary.backendapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import movielibrary.backendapp.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
