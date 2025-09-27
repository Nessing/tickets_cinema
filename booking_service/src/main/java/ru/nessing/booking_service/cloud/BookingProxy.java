package ru.nessing.booking_service.cloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import ru.nessing.booking_service.entities.Movie;

import java.util.List;

@FeignClient(name = "booking", url = "${name.service.url}" + "${name.service.version_1}")
public interface BookingProxy {

    @GetMapping("movies")
    List<Movie> getMovies();
}
