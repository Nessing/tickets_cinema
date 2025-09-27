package ru.nessing.event_service.entities.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import ru.nessing.event_service.entities.ScheduleDataInf;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Data
@Builder
@AllArgsConstructor
public class ScheduleDto implements ScheduleDataInf {

    private UUID id;
    private String movie;
    private String hall;
    private Integer capacity;
    private Integer bookingSeats;
    private LocalDateTime showtime;
}
