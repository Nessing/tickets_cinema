package ru.nessing.booking_service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nessing.booking_service.cloud.BookingProxy;
import ru.nessing.booking_service.entities.Movie;
import ru.nessing.booking_service.entities.SessionInfo;
import ru.nessing.booking_service.entities.TransferSeat;

import java.util.List;

@RestController("/")
public class BookingController {

    private final BookingProxy bookingProxy;

    public BookingController(BookingProxy bookingProxy) {
        this.bookingProxy = bookingProxy;
    }

    @GetMapping("movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = bookingProxy.getMovies();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("sessions")
    public ResponseEntity<List<SessionInfo>> getSessions() {
        List<SessionInfo> sessions = bookingProxy.getSessions();
        return ResponseEntity.ok(sessions);
    }

    @GetMapping("session/{sessionId}")
    public ResponseEntity<SessionInfo> getSession(@PathVariable String sessionId) {
        SessionInfo sessionInfo = bookingProxy.getSessionInfo(sessionId);
        return ResponseEntity.ok(sessionInfo);
    }

    @PostMapping("add_seats")
    public ResponseEntity<String> addSeat(@RequestBody TransferSeat seat) {
        return ResponseEntity.ok(bookingProxy.postSeats(seat));
    }
}
