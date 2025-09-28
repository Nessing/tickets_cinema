package ru.nessing.booking_service.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookingServiceException extends RuntimeException {

    @ExceptionHandler(StreamServiceException.class)
    public ResponseEntity<ErrorDetails> handleBadRequest(StreamServiceException e) {
        return ResponseEntity.badRequest().body(ErrorDetails.builder().message(e.getMessage()).build());
    }
}
