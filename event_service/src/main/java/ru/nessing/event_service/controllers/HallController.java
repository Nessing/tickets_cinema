package ru.nessing.event_service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nessing.event_service.entities.Hall;
import ru.nessing.event_service.services.HallService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class HallController {

    private final HallService hallService;

    public HallController(HallService hallService) {
        this.hallService = hallService;
    }

    @GetMapping("halls")
    public ResponseEntity<List<Hall>> getAllHalls() {
        return ResponseEntity.ok(hallService.getAllHalls());
    }

    @GetMapping("hall/{id}")
    public ResponseEntity<Hall> getHallById(@PathVariable UUID id) {
        Hall hall = hallService.getHallById(id);
        return ResponseEntity.ok(hall);
    }
}
