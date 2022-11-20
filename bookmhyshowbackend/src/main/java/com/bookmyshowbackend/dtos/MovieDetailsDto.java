package com.bookmyshowbackend.dtos;

import lombok.Data;

@Data
public class MovieDetailsDto {
    private String theaterName;
    private Float price;
    private String timings;
}
