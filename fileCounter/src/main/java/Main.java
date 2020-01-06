import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        try {
            long moviesAmount =
                    getMovieAmount("/home/inzheneher") + getMovieAmount("/media/DATA/");
            System.out.println("Total movies amount: " + moviesAmount);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
