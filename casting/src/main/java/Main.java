import lombok.extern.slf4j.Slf4j;
import zoo.Animal;
import zoo.Tiger;

@Slf4j
public class Main {

    public static void main(String[] args) {

        Animal animal = new Animal("rat", 12, "green");
        Tiger tiger = new Tiger(animal);

        log.info(tiger.toString());
    }
}
