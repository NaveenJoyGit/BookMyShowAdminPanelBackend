package com.bookmyshowbackend.controllers;

import com.bookmyshowbackend.dtos.AddMovieRequestDto;
import com.bookmyshowbackend.dtos.MovieDetailsResponseDto;
import com.bookmyshowbackend.entities.MoviesEntity;
import com.bookmyshowbackend.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class MoviesController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies/all")
    public List<MoviesEntity> showAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("movie/details/{id}")
    public List<MovieDetailsResponseDto> getMovieDetails(@PathVariable("id") Integer id) {
        return movieService.getMovieDetails(id);
    }

    @PostMapping("movie/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody AddMovieRequestDto requestDto) {
        try {
            movieService.addMovie(requestDto);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
    @PostMapping("movie/edit-movie/{id}")
    public ResponseEntity<String> editMovie(@RequestBody AddMovieRequestDto requestDto, @PathVariable("id") Integer id) {
        try {
            movieService.editMovie(requestDto, id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
