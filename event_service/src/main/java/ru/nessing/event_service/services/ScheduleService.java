package ru.nessing.event_service.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.nessing.event_service.entities.Schedule;
import ru.nessing.event_service.entities.ScheduleDataInf;
import ru.nessing.event_service.entities.ScheduleDto;
import ru.nessing.event_service.entities.TransferSeats;
import ru.nessing.event_service.exceptions.exceptionsList.NotFoundSchedule;
import ru.nessing.event_service.exceptions.exceptionsList.TooMuchSeat;
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

    @Transactional
    public String bookingSeatInSession(TransferSeats transferSeats) {
        Optional<ScheduleDataInf> schedule = scheduleRepository.findScheduleInfoById(transferSeats.getSessionId());
        if (schedule.isPresent()) {
            int addSeats = schedule.get().getBookingSeats() + transferSeats.getSeatCount();
            if (addSeats <= schedule.get().getCapacity()) {
                Optional<Schedule> currentSchedule = scheduleRepository.findScheduleById(transferSeats.getSessionId());
                currentSchedule.get().setBookingSeats(addSeats);
                scheduleRepository.save(currentSchedule.get());
                return "Мест забронировано: " + addSeats + " на сеанс: " + schedule.get().getMovie();
            } else {
                throw new TooMuchSeat();
            }
        } else {
            throw new NotFoundSchedule();
        }
    }
}
