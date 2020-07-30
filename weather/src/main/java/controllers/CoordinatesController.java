package controllers;

import entity.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import repository.RequestLogRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * inzheneher created on 22/07/2020 inside the package - controllers
 */
@Controller
public class CoordinatesController {

    private final RequestLogRepository requestLogRepository;
    private List<Request> requestList;

    public CoordinatesController(RequestLogRepository requestLogRepository) {
        this.requestLogRepository = requestLogRepository;
    }

    @RequestMapping("/")
    public String redirect() {
        return "/coordinates";
    }

    @GetMapping("/coordinates")
    public String addCoordinates(HttpSession session) {
        if (requestList == null) {
            requestList = (List<Request>) requestLogRepository.findAll();
            session.setAttribute("requestList", requestList);
        }
        return "coordinates";
    }

    @PostMapping("/coordinates")
    public String showFieldsWithValues(Model model, HttpSession session) {
        model.addAttribute("lat", session.getAttribute("lat"));
        model.addAttribute("lon", session.getAttribute("lon"));
        return "coordinates";
    }
}
