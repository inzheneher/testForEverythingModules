package gov.controller;

import gov.dao.PathCollector;
import gov.service.FileScanner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class FileCounterController {

    private Logger logger = Logger.getLogger(FileCounterController.class.getName());

    @GetMapping("/find_movies")
    public String findMovies(Model model) {
        List<String> list = new FileScanner().scanner(new String[]{"/some/path/", "/home/inzheneher/"});
        model.addAttribute("list", list);
        return "find_movies";
    }

    @GetMapping("/find")
    public String showSubmitForm(Model model) {
        model.addAttribute("paths", new PathCollector());
        return "input_path";
    }

    @PostMapping("/input_path")
    public String submitPathsAndFindMovies(@ModelAttribute PathCollector paths, Model model) {
        logger.info("Paths: " + paths.getPath());
        List<String> list = new FileScanner().scanner(paths.getPath().split(" "));
        model.addAttribute("list", list);
        return "results";
    }
}
