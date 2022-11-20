package com.bookmyshowbackend;

import com.bookmyshowbackend.entities.MovieDetailsEntity;
import com.bookmyshowbackend.entities.MoviesEntity;
import com.bookmyshowbackend.repositories.MovieDetailsRepository;
import com.bookmyshowbackend.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookmhyshowbackendApplication implements ApplicationRunner {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieDetailsRepository movieDetailsRepository;

    public static void main(String[] args) {
        SpringApplication.run(BookmhyshowbackendApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        MoviesEntity m1 = new MoviesEntity("Avengers", "Chris Evans, RDJ, Chris Hemsworth, Tom Holand", "English", "Action", 10);
        MoviesEntity m2 = new MoviesEntity("James Bond", "Daniel Craig", "English", "Action", 5);
        movieRepository.save(m1);
        movieRepository.save(m2);
        MovieDetailsEntity md1 =
                new MovieDetailsEntity(m1, "Banglore", "PVR", "10:00AM, 1:00PM", 300.0f);
        MovieDetailsEntity md2 =
                new MovieDetailsEntity(m1, "Kochi", "SHenoys", "10:00AM, 1:00PM", 400.0f);
        MovieDetailsEntity md5 =
                new MovieDetailsEntity(m1, "Kochi", "Central", "10:00AM, 1:00PM", 200.0f);
        MovieDetailsEntity md3 =
                new MovieDetailsEntity(m2, "Banglore", "PVR", "10:00AM, 1:00PM", 300.0f);
        MovieDetailsEntity md4 =
                new MovieDetailsEntity(m2, "Kochi", "SHenoys", "10:00AM, 1:00PM", 400.0f);
        movieDetailsRepository.save(md1);
        movieDetailsRepository.save(md2);
        movieDetailsRepository.save(md3);
        movieDetailsRepository.save(md4);
        movieDetailsRepository.save(md5);
    }
}
