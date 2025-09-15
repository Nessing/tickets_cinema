package ru.nessing.event_service.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MovieServiceException {

    @ExceptionHandler(NotFoundMovie.class)
    public ResponseEntity<ErrorDetails> notFoundMovieException() {
        ErrorDetails errorDetails = ErrorDetails.builder().message("Фильм не найден").build();
        return ResponseEntity.badRequest().body(errorDetails);
    }

}
