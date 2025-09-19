package ru.nessing.event_service.services;

import org.springframework.stereotype.Service;
import ru.nessing.event_service.entities.Schedule;
import ru.nessing.event_service.entities.ScheduleDto;
import ru.nessing.event_service.repositories.ScheduleRepository;

import java.util.Date;
import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> getAllSchedule() {
        return scheduleRepository.findAll();
    }

    public List<ScheduleDto> getAllScheduleDto() {
        return scheduleRepository.findSchedules();
    }

    public List<ScheduleDto> getScheduleDtoByDate(String date) {
        return scheduleRepository.findByDate(date);
    }
}
