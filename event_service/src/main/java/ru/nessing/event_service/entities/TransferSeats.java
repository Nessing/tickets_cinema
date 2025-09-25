package ru.nessing.event_service.entities;

import lombok.Data;

import java.util.UUID;

@Data
public class TransferSeats {

    private UUID sessionId;
    private Integer seatCount;
}
