import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.stream.Stream;

import static java.nio.file.Files.*;

public class Reader {

    private static String absolutePath = new File("").getAbsolutePath();
    private static String relativePath = "/fileReader/src/main/resources/user.id";
    private static String path = absolutePath.concat(relativePath);
    private static LinkedList<String> linkedList = new LinkedList<>();

    public static void main(String[] args) {
        try (Stream<String> stream = lines(Paths.get(path))) {
            stream.forEach(linkedList::add);
            if (!linkedList.isEmpty()) {
                linkedList.removeFirst();
            }
            linkedList.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Files.write(Paths.get(path), linkedList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
