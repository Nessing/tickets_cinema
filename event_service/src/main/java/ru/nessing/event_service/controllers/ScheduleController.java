package ru.nessing.event_service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nessing.event_service.entities.Schedule;
import ru.nessing.event_service.entities.ScheduleDto;
import ru.nessing.event_service.services.ScheduleService;

import java.util.List;

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

    @GetMapping("scheduleDtoByDate/{date}")
    public ResponseEntity<List<ScheduleDto>> getSchedulesByDate(@PathVariable String date) {
        return ResponseEntity.ok(scheduleService.getScheduleDtoByDate(date));
    }
}
