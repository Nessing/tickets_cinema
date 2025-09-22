package ru.nessing.event_service.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class ScheduleDto {

    private UUID id;
    private String movie;
    private String hall;

    @JsonFormat(pattern = "dd.MM.yy HH:mm")
    private Date showtime;

}
