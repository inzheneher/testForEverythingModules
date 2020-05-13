package gov.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class FileScanner {

    private final Logger LOGGER = LoggerFactory.getLogger(FileScanner.class);
    private long START_TIME;
    private long STOP_TIME;
    private String NS = "ns";
    private String MS = "ms";

    public Map<Integer, String> scanFileSystemAndGetMoviesMap(String[] args) {
        Map<Integer, String> movieMap = new HashMap<>();
        if (args.length > 0) {
            START_TIME = System.currentTimeMillis();
            for (String arg : args) {
                if (isPathExist(arg)) {
                    try {
                        movieMap = getMovieMap(arg);
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
        return movieMap;
    }

    private void logTime(String time, long start, long stop) {
        LOGGER.info("WORKING_TIME: ".concat(String.valueOf(stop - start)).concat(" ").concat(time));
    }

    private boolean isPathExist(String path) {
        return Files.exists(Paths.get(path), LinkOption.NOFOLLOW_LINKS);
    }

    private Map<Integer, String> getMovieMap(String path) throws IOException {
        List<String> moviesList = Files
                .walk(Paths.get(path))
                .parallel()
                .filter(Files::isRegularFile)
                .map(Path::toString)
                .filter(f -> f.endsWith(".avi") || f.endsWith(".mkv") || f.endsWith(".mp4"))
                .collect(Collectors.toList());

        return IntStream.range(0, moviesList.size()).boxed().collect(Collectors.toMap(i -> ++i, moviesList::get));
    }

    private void saveMoviesNamesToDb(String path) {

    }
}
