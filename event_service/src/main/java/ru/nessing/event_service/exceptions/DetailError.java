package ru.nessing.event_service.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetailError {
    private String message;

    public static DetailError message(String message) {
        return new DetailError(message);
    }
}
