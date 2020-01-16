package org.mav.repository;

import org.mav.dao.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Long> {

    List<Movie> findByMovieName(String movieName);

    Movie findById(long id);
}
