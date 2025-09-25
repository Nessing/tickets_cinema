package ru.nessing.event_service.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.UUID;

public interface ScheduleDataInf {
    UUID getId();
    String getMovie();
    String getHall();
    Integer getCapacity();
    Integer getBookingSeats();

    @JsonFormat(pattern = "dd.MM.yy HH:mm")
    LocalDateTime getShowtime();

}
