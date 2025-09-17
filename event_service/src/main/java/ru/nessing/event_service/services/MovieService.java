package ru.nessing.event_service.services;

import org.springframework.stereotype.Service;
import ru.nessing.event_service.entities.Movie;
import ru.nessing.event_service.exceptions.NotFoundMovie;
import ru.nessing.event_service.repositories.MovieRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(UUID id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()) {
            return movie.get();
        } else {
            throw new NotFoundMovie();
        }
    }
}
