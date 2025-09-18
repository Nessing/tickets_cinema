package ru.nessing.event_service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.nessing.event_service.entities.Movie;
import ru.nessing.event_service.exceptions.exceptionsList.NotFoundMovie;
import ru.nessing.event_service.repositories.MovieRepository;
import ru.nessing.event_service.services.MovieService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTests {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    @Test
    @DisplayName("Возврат фильма по ID")
    public void findMovies() {
        Movie movie1 = new Movie();
        movie1.setTitle("Harry Potter");
        movie1.setId(UUID.randomUUID());
        movie1.setDurationInMin(142);
        Movie movie2 = new Movie();
        movie2.setTitle("Transformers");
        movie2.setId(UUID.randomUUID());
        movie2.setDurationInMin(110);

        given(movieRepository.findById(movie1.getId()))
                .willReturn(Optional.of(movie1));

        Movie currentMovie = movieService.getMovieById(movie1.getId());

        verify(movieRepository).findById(currentMovie.getId());
    }

    @Test
    @DisplayName("Исключение если фильм не найден")
    public void notFoundMovies() {
        UUID movieId = UUID.randomUUID();

        given(movieRepository.findById(movieId))
                .willReturn(Optional.empty());

        assertThrows(NotFoundMovie.class,
                () -> movieService.getMovieById(movieId));

        verify(movieRepository, never()).findById(UUID.randomUUID());
    }
}
