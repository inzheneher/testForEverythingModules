package controllers;

import com.google.gson.Gson;
import entity.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import repository.RequestLogRepository;
import responses.OpenWeatherResponse;
import services.RequestService;

import java.sql.Timestamp;

/**
 * inzheneher created on 22/07/2020 inside the package - controllers
 */
@Controller
public class WeatherController {

    private final RequestService requestService;
    private final RequestLogRepository requestLogRepository;

    public WeatherController(RequestService requestService, RequestLogRepository requestLogRepository) {
        this.requestService = requestService;
        this.requestLogRepository = requestLogRepository;
    }

    //TODO: add button to redirect to main page

    @PostMapping("/setCoordinates")
    public String showCoordinates(@RequestParam(name = "lat", required = false, defaultValue = "0") String lat,
                                  @RequestParam(name = "lon", required = false, defaultValue = "0") String lon,
                                  Model model) {
        //TODO: change double to string in db and in code
        OpenWeatherResponse openWeatherResponse = requestService.getOpenWeatherResponse(lat, lon);
        requestLogRepository.save(
                new Request(
                        new Timestamp(System.currentTimeMillis()),
                        lat,
                        lon,
                        new Gson().toJson(openWeatherResponse, OpenWeatherResponse.class)));
        model.addAttribute("temperature", String.valueOf(openWeatherResponse.getMain().getTemp()));
        return "setCoordinates";
    }
}
