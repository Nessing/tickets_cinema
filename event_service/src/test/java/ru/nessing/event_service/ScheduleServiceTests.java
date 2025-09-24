package ru.nessing.event_service;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.nessing.event_service.entities.ScheduleDto;
import ru.nessing.event_service.exceptions.exceptionsList.NotFoundSchedule;
import ru.nessing.event_service.repositories.ScheduleRepository;
import ru.nessing.event_service.services.ScheduleService;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ScheduleServiceTests {


    @Mock
    private ScheduleRepository scheduleRepository;

    @InjectMocks
    private ScheduleService scheduleService;

    @Test
    @DisplayName("Поиск сеанса по ID")
    public void findSession() {
        ScheduleDto scheduleDto = ScheduleDto.builder()
                .id(UUID.randomUUID())
                .movie("Test Film")
                .hall("Test Hall")
                .showtime(LocalDateTime.of(2025, Calendar.SEPTEMBER, 15, 16, 20))
                .build();
        given(scheduleRepository.findDtoById(scheduleDto.getId())).willReturn(Optional.of(scheduleDto));

        ScheduleDto currentScheduleDto = scheduleService.getScheduleDtoById(scheduleDto.getId());

        verify(scheduleRepository).findDtoById(currentScheduleDto.getId());
    }

    @Test
    @DisplayName("Не найден сеанс")
    public void notFoundSession() {
        UUID sessionId = UUID.randomUUID();

        given(scheduleRepository.findDtoById(sessionId))
                .willReturn(Optional.empty());

        assertThrows(NotFoundSchedule.class,
                () -> scheduleService.getScheduleDtoById(sessionId));

        verify(scheduleRepository, never()).findDtoById(UUID.randomUUID());
    }
}
