package com.bookmyshowbackend.services;

import com.bookmyshowbackend.dtos.AddMovieRequestDto;
import com.bookmyshowbackend.dtos.MovieDetailsDto;
import com.bookmyshowbackend.dtos.MovieDetailsResponseDto;
import com.bookmyshowbackend.entities.MovieDetailsEntity;
import com.bookmyshowbackend.entities.MoviesEntity;
import com.bookmyshowbackend.repositories.MovieDetailsRepository;
import com.bookmyshowbackend.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieDetailsRepository movieDetailsRepository;

    public List<MoviesEntity> getAllMovies() {
        return movieRepository.findAll();
    }

    public List<MovieDetailsResponseDto> getMovieDetails(Integer id) {
        MoviesEntity moviesEntity = movieRepository.findById(id).orElse(new MoviesEntity());
        List<MovieDetailsEntity> movieDetailsEntityList = moviesEntity.getMovieDetailsEntityList();
//        Map<String, MovieDetailsDto> locationMovieMap = movieDetailsEntityList.stream().collect(Collectors.toMap(MovieDetailsEntity::getLocation, this::movieDetilsEntityMapper));
        Map<String, List<MovieDetailsEntity>> locationMovieMap = movieDetailsEntityList.stream().collect(Collectors.groupingBy(MovieDetailsEntity::getLocation));
        List<MovieDetailsResponseDto> response = getResponseFromMap(locationMovieMap);
//        List<MovieDetailsResponseDto> response = movieDetailsEntityList.stream().map(this::movieEntityMapper).collect(Collectors.toList());
        return response;
    }

    private List<MovieDetailsResponseDto> getResponseFromMap(Map<String, List<MovieDetailsEntity>> locationMovieMap) {
        List<MovieDetailsResponseDto> responseDtos = new ArrayList<>();
        for (Map.Entry<String, List<MovieDetailsEntity>> entry : locationMovieMap.entrySet()) {
            MovieDetailsResponseDto responseDto = new MovieDetailsResponseDto();
            responseDto.setLocation(entry.getKey());
            List<MovieDetailsDto> movieDetailsDtoList = entry.getValue().stream().map(this::movieDetilsEntityMapper).collect(Collectors.toList());
            responseDto.setMovieDetails(movieDetailsDtoList);
            responseDtos.add(responseDto);
        }
        return responseDtos;
    }

    public MovieDetailsResponseDto movieEntityMapper(MovieDetailsEntity movieDetailsEntity) {
        MovieDetailsResponseDto res = new MovieDetailsResponseDto();
        res.setLocation(movieDetailsEntity.getLocation());
        MovieDetailsDto md = new MovieDetailsDto();
        md.setPrice(movieDetailsEntity.getPrice());
        md.setTimings(movieDetailsEntity.getTimings());
        md.setTheaterName(movieDetailsEntity.getTheaterName());
//        res.setMovieDetails(md);
        return res;
    }

    public MovieDetailsDto movieDetilsEntityMapper(MovieDetailsEntity movieDetailsEntity) {
        MovieDetailsDto md = new MovieDetailsDto();
        md.setPrice(movieDetailsEntity.getPrice());
        md.setTimings(movieDetailsEntity.getTimings());
        md.setTheaterName(movieDetailsEntity.getTheaterName());
        return md;
    }

    public void addMovie(AddMovieRequestDto requestDto) {
        MoviesEntity m = new MoviesEntity(requestDto.getMovieName(), requestDto.getCast(), requestDto.getLanguage(), requestDto.getGenre(), requestDto.getNoOfLocations());
        movieRepository.save(m);
    }

    public void editMovie(AddMovieRequestDto requestDto, Integer id) {
        MoviesEntity moviesEntity = movieRepository.findById(id).orElseThrow(IllegalAccessError::new);
        if(!requestDto.getCast().isBlank()) moviesEntity.setCast(requestDto.getCast());
        if(!requestDto.getMovieName().isBlank()) moviesEntity.setName(requestDto.getMovieName());
        if(!requestDto.getLanguage().isBlank()) moviesEntity.setLanguage(requestDto.getLanguage());
        if(!requestDto.getGenre().isBlank()) moviesEntity.setGenre(requestDto.getGenre());
        if(requestDto.getNoOfLocations() != null) moviesEntity.setNoOfLocationsForBooking(requestDto.getNoOfLocations());
        movieRepository.save(moviesEntity);
    }
}
