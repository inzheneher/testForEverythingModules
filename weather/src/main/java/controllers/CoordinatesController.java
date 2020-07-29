package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * inzheneher created on 22/07/2020 inside the package - controllers
 */
@Controller
public class CoordinatesController {

    @RequestMapping("/")
    public String redirect() {
        return "/coordinates";
    }

    @GetMapping("/coordinates")
    public String addCoordinates(Model model) {
        return "coordinates";
    }

    @PostMapping("/coordinates")
    public String showFieldsWithValues(Model model, HttpSession session) {
        model.addAttribute("lat", session.getAttribute("lat"));
        model.addAttribute("lon", session.getAttribute("lon"));
        return "coordinates";
    }
}
