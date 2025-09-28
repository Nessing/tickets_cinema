package ru.nessing.booking_service.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SessionInfo {
    private UUID id;
    private String movie;
    private String hall;
    private Integer capacity;
    private Integer bookingSeats;

    @JsonFormat(pattern = "dd.MM.yy HH:mm")
    private LocalDateTime showtime;
}
