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
import utils.ResponseAndJson;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

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

    //TODO: login page with spring security

    @PostMapping("/setCoordinates")
    public String showCoordinates(@RequestParam(name = "lat", required = false, defaultValue = "0") String lat,
                                  @RequestParam(name = "lon", required = false, defaultValue = "0") String lon,
                                  Model model,
                                  HttpSession session) {
        List<Request> requestList = requestService.setList(session.getAttribute("requestList"));
        for (Request request : requestList) {
            if (request.getLatitude().equals(lat) && request.getLongitude().equals(lon)) {
                model.addAttribute("temperature", new Gson().fromJson(request.getRespond(), OpenWeatherResponse.class).getMain().getTemp());
                session.setAttribute("lat", lat);
                session.setAttribute("lon", lon);
                return "setCoordinates";
            }
        }
        ResponseAndJson responseAndJson = requestService.getOpenWeatherResponseAndJson(lat, lon);
        requestLogRepository.save(
                new Request(
                        new Timestamp(System.currentTimeMillis()),
                        lat,
                        lon,
                        responseAndJson.getJson()));
        model.addAttribute("temperature", String.valueOf(responseAndJson.getResponse().getMain().getTemp()));
        requestList = (List<Request>) requestLogRepository.findAll();
        session.setAttribute("requestList", requestList);
        session.setAttribute("lat", lat);
        session.setAttribute("lon", lon);
        return "setCoordinates";
    }
}
