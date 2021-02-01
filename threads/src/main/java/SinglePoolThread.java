import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * inzheneher created on 31/01/2021 inside the package - PACKAGE_NAME
 */
public class SinglePoolThread {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 100; i++) {
            service.execute(new Task());
            System.out.printf("Task №%s is executed%n", i);
        }
        System.out.printf("Thread name: %s%n", Thread.currentThread().getName());
    }
}
