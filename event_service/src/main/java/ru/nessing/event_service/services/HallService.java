package ru.nessing.event_service.services;

import org.springframework.stereotype.Service;
import ru.nessing.event_service.entities.Hall;
import ru.nessing.event_service.exceptions.exceptionsList.NotFoundHall;
import ru.nessing.event_service.repositories.HallRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HallService {

    private final HallRepository hallRepository;

    public HallService(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    public List<Hall> getAllHalls() {
        return hallRepository.findAll();
    }

    public Hall getHallById(UUID id) {
        Optional<Hall> hall = hallRepository.findById(id);
        if (hall.isPresent()) {
            return hall.get();
        } else {
            throw new NotFoundHall();
        }
    }
}
