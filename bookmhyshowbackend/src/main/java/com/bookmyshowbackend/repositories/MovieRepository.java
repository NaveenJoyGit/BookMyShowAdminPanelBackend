package com.bookmyshowbackend.repositories;

import com.bookmyshowbackend.entities.MoviesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MoviesEntity, Integer> {
}
