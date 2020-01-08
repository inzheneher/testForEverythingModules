package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Main {

    private static Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static long START_TIME;
    private static long STOP_TIME;
    private static String NS = "ns";
    private static String MS = "ms";

    public static void main(String[] args) {

        if (args.length > 0) {
            START_TIME = System.nanoTime();
            for (String arg : args) {
                System.out.println(arg);
            }
            STOP_TIME = System.nanoTime();
            logTime(NS, START_TIME, STOP_TIME);
        } else {
            START_TIME = System.currentTimeMillis();
            try {
                long moviesAmount =
                        getMovieAmount("/home/inzheneher") + getMovieAmount("/media/DATA/");
                System.out.println("Total movies amount: " + moviesAmount);
            } catch (IOException e) {
                e.printStackTrace();
            }
            STOP_TIME = System.currentTimeMillis();
            logTime(MS, START_TIME, STOP_TIME);
        }
    }

    private static void logTime(String time, long start, long stop) {
        LOGGER.info("WORKING_TIME: ".concat(String.valueOf(stop - start)).concat(" ").concat(time));
    }

    private static int getMovieAmount(String path) throws IOException {
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
}
