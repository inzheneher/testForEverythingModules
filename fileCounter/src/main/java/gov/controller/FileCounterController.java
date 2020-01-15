package gov.controller;

import gov.dao.PathCollector;
import gov.service.FileScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
public class FileCounterController {

    private FileScanner fileScanner;
    private Logger logger = Logger.getLogger(FileCounterController.class.getName());

    @Autowired
    public FileCounterController(FileScanner fileScanner) {
        this.fileScanner = fileScanner;
    }

    @PostMapping("/input_path")
    public String submitPathsAndFindMovies(@ModelAttribute PathCollector paths, Model model) {
        logger.info("Paths: " + paths.getPath());
        Map<Integer, String> moviesMap = fileScanner.scanFileSystemAndGetMoviesMap(paths.getPath().split(" "));
        model.addAttribute("moviesMap", moviesMap);
        return "results";
    }
}
