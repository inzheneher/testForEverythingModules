package gov.controller;

import gov.dao.PathCollector;
import gov.service.FileScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class FileCounterController {

    private final Logger logger = LoggerFactory.getLogger(FileCounterController.class);
    private FileScanner fileScanner;

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
