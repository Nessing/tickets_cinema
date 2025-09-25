package ru.nessing.event_service.services;

import org.springframework.stereotype.Service;
import ru.nessing.event_service.entities.Schedule;
import ru.nessing.event_service.entities.ScheduleDataInf;
import ru.nessing.event_service.entities.ScheduleDto;
import ru.nessing.event_service.exceptions.exceptionsList.NotFoundSchedule;
import ru.nessing.event_service.repositories.ScheduleRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public ScheduleDataInf getScheduleDtoById(UUID id) {
        Optional<ScheduleDataInf> schedule = scheduleRepository.findScheduleInfoById(id);
        if (schedule.isPresent()) {
            return schedule.get();
        } else {
            throw new NotFoundSchedule();
        }
    }
}
