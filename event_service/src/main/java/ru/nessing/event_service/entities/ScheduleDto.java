package ru.nessing.event_service.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ScheduleDto {

    private String movie;
    private String hall;

    @JsonFormat(pattern = "dd.MM.yy HH:mm", timezone = "Europe/Moscow")
    private Date showtime;

}
