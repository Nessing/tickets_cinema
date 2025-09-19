package ru.nessing.event_service.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.nessing.event_service.exceptions.exceptionsList.NotFoundHall;
import ru.nessing.event_service.exceptions.exceptionsList.NotFoundMovie;
import ru.nessing.event_service.exceptions.exceptionsList.NotFoundSchedule;

@RestControllerAdvice
public class MovieServiceException {

    @ExceptionHandler(NotFoundMovie.class)
    public ResponseEntity<DetailError> notFoundMovieException() {
        return ResponseEntity.badRequest().body(DetailError.message("Фильм не найден"));
    }

    @ExceptionHandler(NotFoundHall.class)
    public ResponseEntity<DetailError> notFoundHallException() {
        return ResponseEntity.badRequest().body(DetailError.message("Зал не найден"));
    }

    @ExceptionHandler(NotFoundSchedule.class)
    public ResponseEntity<DetailError> notFoundScheduleException() {
        return ResponseEntity.badRequest().body(DetailError.message("Сеанс не найден"));
    }
}
