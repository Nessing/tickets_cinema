package ru.nessing.booking_service.cloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.nessing.booking_service.entities.Movie;
import ru.nessing.booking_service.entities.SessionInfo;
import ru.nessing.booking_service.entities.TransferSeat;

import java.util.List;

@FeignClient(name = "booking", url = "${name.service.url}" + "${name.service.version_1}")
public interface BookingProxy {

    @GetMapping("movies")
    List<Movie> getMovies();

    @GetMapping("schedulesDto")
    List<SessionInfo> getSessions();

    @GetMapping("showtimes/{sessionId}")
    SessionInfo getSessionInfo(@PathVariable String sessionId);

    @PostMapping("add_seats")
    String postSeats(@RequestBody TransferSeat seats);
}
