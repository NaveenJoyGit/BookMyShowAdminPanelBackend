package com.bookmyshowbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
//@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoviesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String cast;
    private String language;
    private String genre;
    private Integer noOfLocationsForBooking;
    @OneToMany(mappedBy = "movieId")
    private List<MovieDetailsEntity> movieDetailsEntityList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getNoOfLocationsForBooking() {
        return noOfLocationsForBooking;
    }

    public void setNoOfLocationsForBooking(Integer noOfLocationsForBooking) {
        this.noOfLocationsForBooking = noOfLocationsForBooking;
    }

    @JsonIgnore
    public List<MovieDetailsEntity> getMovieDetailsEntityList() {
        return movieDetailsEntityList;
    }

    public void setMovieDetailsEntityList(List<MovieDetailsEntity> movieDetailsEntityList) {
        this.movieDetailsEntityList = movieDetailsEntityList;
    }

    public MoviesEntity(String name, String cast, String language,
                        String genre, Integer noOfLocationsForBooking) {
        this.name = name;
        this.cast = cast;
        this.language = language;
        this.genre = genre;
        this.noOfLocationsForBooking = noOfLocationsForBooking;
    }

    public MoviesEntity(String name, String cast, String language,
                        String genre, Integer noOfLocationsForBooking,
                        List<MovieDetailsEntity> movieDetailsEntityList) {
        this.name = name;
        this.cast = cast;
        this.language = language;
        this.genre = genre;
        this.noOfLocationsForBooking = noOfLocationsForBooking;
        this.movieDetailsEntityList = movieDetailsEntityList;
    }
}
