package com.bookmyshowbackend.dtos;

import lombok.Data;

@Data
public class AddMovieRequestDto {
    private String movieName;
    private String cast;
    private String language;
    private String genre;
    private Integer noOfLocations;
}
