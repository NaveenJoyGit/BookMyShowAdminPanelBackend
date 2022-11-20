package com.bookmyshowbackend.repositories;

import com.bookmyshowbackend.entities.MovieDetailsEntity;
import com.bookmyshowbackend.entities.MoviesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieDetailsRepository extends JpaRepository<MovieDetailsEntity, Integer> {

    List<MovieDetailsEntity> findByMovieId(MoviesEntity moviesEntity);

}
