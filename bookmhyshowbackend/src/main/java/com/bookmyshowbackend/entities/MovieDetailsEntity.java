package com.bookmyshowbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer movieDetailsId;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private MoviesEntity movieId;
    private String location;
    private String theaterName;
    private String timings;
    private Float price;

    public MovieDetailsEntity(MoviesEntity movieId, String location, String theaterName, String timings, Float price) {
        this.movieId = movieId;
        this.location = location;
        this.theaterName = theaterName;
        this.timings = timings;
        this.price = price;
    }

    public MovieDetailsEntity(String location, String theaterName, String timings, Float price) {
        this.location = location;
        this.theaterName = theaterName;
        this.timings = timings;
        this.price = price;
    }
}
