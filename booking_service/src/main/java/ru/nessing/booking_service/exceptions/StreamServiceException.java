package ru.nessing.booking_service.exceptions;

public class StreamServiceException extends RuntimeException {
    public StreamServiceException(String message) {
        super(message);
    }
}
