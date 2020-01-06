import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        try {
            long moviesAmount = getMovieAmount("/home/inzheneher") + getMovieAmount("/media/DATA/movies");
            System.out.println(moviesAmount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long getMovieAmount(String path) throws IOException {
        return Files
                .walk(Paths.get(path))
                .parallel()
                .filter(Files::isRegularFile)
                .filter(Files::isWritable)
                .filter(f ->
                        f.getFileName().toString().contains(".avi") ||
                                f.getFileName().toString().contains(".mkv"))
                .count();
    }
}
