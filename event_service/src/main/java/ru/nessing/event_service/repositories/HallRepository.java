package ru.nessing.event_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nessing.event_service.entities.Hall;

import java.util.UUID;

@Repository
public interface HallRepository extends JpaRepository<Hall, UUID> {

}
