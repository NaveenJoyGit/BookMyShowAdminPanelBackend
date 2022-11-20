package com.bookmyshowbackend.dtos;

import lombok.Data;

import java.util.List;

@Data
public class MovieDetailsResponseDto {
    private String location;
    private List<MovieDetailsDto> movieDetails;
}
