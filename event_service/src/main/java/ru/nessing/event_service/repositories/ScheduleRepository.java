package ru.nessing.event_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import ru.nessing.event_service.entities.Schedule;
import ru.nessing.event_service.entities.ScheduleDataInf;
import ru.nessing.event_service.entities.DTOs.ScheduleDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, UUID> {

    @Query(nativeQuery = true,
            value = "SELECT CAST(schedules.id as VARCHAR) as id, movies.title as movie, " +
                    "halls.name as hall, halls.capacity as capacity, booking_seats, showtime " +
                    "FROM schedules " +
                    "INNER JOIN movies ON movie_id = movies.id " +
                    "INNER JOIN halls ON hall_id = halls.id")
    List<ScheduleDataInf> findSchedules();

    @Query(nativeQuery = true,
            value = "SELECT movies.title as title, halls.name as hall, showtime " +
                    "FROM schedules " +
                    "INNER JOIN movies ON movie_id = movies.id " +
                    "INNER JOIN halls ON hall_id = halls.id " +
                    "WHERE CAST(showtime AS DATE) = :date " +
                    "ORDER BY showtime")
    List<ScheduleDto> findByDate(@PathVariable("date") String date);

    @Query(nativeQuery = true,
            value = "SELECT CAST(schedules.id as VARCHAR) as id, movies.title as movie, " +
                    "halls.name as hall, halls.capacity as capacity, booking_seats, showtime " +
                    "FROM schedules " +
                    "INNER JOIN movies ON movie_id = movies.id " +
                    "INNER JOIN halls ON hall_id = halls.id " +
                    "WHERE schedules.id = :id")
    Optional<ScheduleDataInf> findScheduleInfoById(@PathVariable("id") UUID id);

    Optional<Schedule> findScheduleById(UUID id);
}
