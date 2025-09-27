package ru.nessing.event_service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nessing.event_service.entities.Schedule;
import ru.nessing.event_service.entities.ScheduleDataInf;
import ru.nessing.event_service.entities.DTOs.ScheduleDto;
import ru.nessing.event_service.entities.TransferSeats;
import ru.nessing.event_service.services.ScheduleService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("schedules")
    public ResponseEntity<List<Schedule>> getSchedule() {
        return ResponseEntity.ok(scheduleService.getAllSchedule());
    }

    @GetMapping("schedulesDto")
    public ResponseEntity<List<ScheduleDto>> getSchedules() {
        return ResponseEntity.ok(scheduleService.getAllScheduleDto());
    }

    @GetMapping("showtimes")
    public ResponseEntity<List<ScheduleDto>> getSchedulesByDate(@RequestParam String date) {
        return ResponseEntity.ok(scheduleService.getScheduleDtoByDate(date));
    }

    @GetMapping("showtimes/{id}")
    public ResponseEntity<ScheduleDataInf> getSchedulesById(@PathVariable UUID id) {
        return ResponseEntity.ok(scheduleService.getScheduleDtoById(id));
    }

    @PostMapping("add_seats")
    public ResponseEntity<String> postSeats(@RequestBody TransferSeats transferSeats) {
        return ResponseEntity.ok(scheduleService.bookingSeatInSession(transferSeats));
    }
}
