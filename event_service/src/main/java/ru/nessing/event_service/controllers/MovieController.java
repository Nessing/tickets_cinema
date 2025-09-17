package ru.nessing.event_service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nessing.event_service.entities.Movie;
import ru.nessing.event_service.services.MovieService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("movie/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable UUID id) {
        Movie movie = movieService.getMovieById(id);
        return ResponseEntity.ok(movie);
    }
}
