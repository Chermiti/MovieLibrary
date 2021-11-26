package test.backendapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.backendapp.model.Movie;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

}
