package ru.nessing.event_service;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.nessing.event_service.entities.ScheduleDto;
import ru.nessing.event_service.repositories.ScheduleRepository;
import ru.nessing.event_service.services.ScheduleService;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.BDDMockito.given;
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
                .showtime(new Date(2025, Calendar.SEPTEMBER, 15, 16, 20))
                .build();
        given(scheduleRepository.findDtoById(scheduleDto.getId())).willReturn(Optional.of(scheduleDto));

        ScheduleDto currentScheduleDto = scheduleService.scheduleDtoById(scheduleDto.getId());

        verify(scheduleRepository).findDtoById(currentScheduleDto.getId());
    }
}
