package ru.nessing.booking_service.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private String title;
    private Integer durationInMin;
}
