package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import responses.OpenWeatherResponse;
import services.RequestService;

/**
 * inzheneher created on 22/07/2020 inside the package - controllers
 */
@Controller
public class WeatherController {

    private final RequestService requestService;

    public WeatherController(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping("/setCoordinates")
    public String showCoordinates(@RequestParam(name = "lat", required = false, defaultValue = "0") String lat,
                                  @RequestParam(name = "lon", required = false, defaultValue = "0") String lon,
                                  Model model) {
        OpenWeatherResponse openWeatherResponse = requestService.getOpenWeatherResponse(lat, lon);
        model.addAttribute("temperature", String.valueOf(openWeatherResponse.getMain().getTemp()));
        return "setCoordinates";
    }
}
