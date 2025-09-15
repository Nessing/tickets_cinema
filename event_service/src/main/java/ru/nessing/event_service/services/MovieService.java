package ru.nessing.event_service.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.nessing.event_service.entities.Movie;
import ru.nessing.event_service.repositories.MovieRepository;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return ResponseEntity.ok(movies);
    }
}
