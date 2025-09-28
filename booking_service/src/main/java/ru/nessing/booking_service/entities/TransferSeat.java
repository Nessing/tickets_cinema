package ru.nessing.booking_service.entities;

import lombok.Data;

import java.util.UUID;

@Data
public class TransferSeat {
    private UUID sessionId;
    private Integer seatCount;
}
