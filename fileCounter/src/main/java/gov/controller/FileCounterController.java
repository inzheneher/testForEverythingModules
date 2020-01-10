package gov.controller;

import gov.service.FileScanner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FileCounterController {

    @GetMapping("/find_movies")
    public String findMovies(Model model) {
        List<String> list = new FileScanner().scanner(new String[] {"/some/path/", "/home/inzheneher/"});
        model.addAttribute("list", list);
        return "find_movies";
    }
}
