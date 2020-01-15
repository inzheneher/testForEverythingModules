package gov.service;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class FileScanner {

    private Logger LOGGER = Logger.getLogger(FileScanner.class.getName());
    private long START_TIME;
    private long STOP_TIME;
    private String NS = "ns";
    private String MS = "ms";

    public List<String> scanner(String[] args) {
        List<String> movieList = new ArrayList<>();
        if (args.length > 0) {
            START_TIME = System.currentTimeMillis();
            for (String arg : args) {
                if (isPathExist(arg)) {
                    try {
                        movieList = getMovieList(arg);
//                        long moviesAmount = getMovieAmount(arg);
//                        LOGGER.info("Total movies amount: " + moviesAmount);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    LOGGER.info("Specified path '".concat(arg).concat("' does not exist. Set the path that exist."));
                }
            }
            STOP_TIME = System.currentTimeMillis();
            logTime(MS, START_TIME, STOP_TIME);
        } else {
            LOGGER.info("There is no path for search. Set the path.");
        }
        return movieList;
    }

    private void logTime(String time, long start, long stop) {
        LOGGER.info("WORKING_TIME: ".concat(String.valueOf(stop - start)).concat(" ").concat(time));
    }

    private boolean isPathExist(String path) {
        return Files.exists(Paths.get(path), LinkOption.NOFOLLOW_LINKS);
    }

    private int getMovieAmount(String path) throws IOException {
        List<String> movieList = Files
                .walk(Paths.get(path))
                .parallel()
                .filter(Files::isRegularFile)
                .map(Path::toString)
                .filter(f -> f.endsWith(".avi") || f.endsWith(".mkv") || f.endsWith(".mp4"))
                .collect(Collectors.toList());
        movieList.forEach(System.out::println);
        return movieList.size();
    }

    private List<String> getMovieList(String path) throws IOException {
        return Files
                .walk(Paths.get(path))
                .parallel()
                .filter(Files::isRegularFile)
                .map(Path::toString)
                .filter(f -> f.endsWith(".avi") || f.endsWith(".mkv") || f.endsWith(".mp4"))
                .collect(Collectors.toList());
    }
}
