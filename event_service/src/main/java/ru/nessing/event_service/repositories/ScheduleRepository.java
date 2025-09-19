package ru.nessing.event_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import ru.nessing.event_service.entities.Schedule;
import ru.nessing.event_service.entities.ScheduleDto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, UUID> {

    @Query(nativeQuery = true,
            value = "SELECT movies.title as title, halls.name as hall, showtime " +
                    "FROM schedules " +
                    "INNER JOIN movies ON movie_id = movies.id " +
                    "INNER JOIN halls ON hall_id = halls.id")
    List<ScheduleDto> findSchedules();

    @Query(nativeQuery = true,
            value = "SELECT movies.title as title, halls.name as hall, showtime " +
                    "FROM schedules " +
                    "INNER JOIN movies ON movie_id = movies.id " +
                    "INNER JOIN halls ON hall_id = halls.id " +
                    "WHERE CAST(showtime AS DATE) = :date " +
                    "ORDER BY showtime")
    List<ScheduleDto> findByDate(@PathVariable("date") String date);
}
