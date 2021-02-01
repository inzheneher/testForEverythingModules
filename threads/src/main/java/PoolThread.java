import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * inzheneher created on 31/01/2021 inside the package - PACKAGE_NAME
 */
public class PoolThread {
    public static void main(String[] args) {
        //create the pool
        ExecutorService service = Executors.newFixedThreadPool(10);
        //submit the tasks for execution
        for (int i = 0; i < 100; i++) {
            service.execute(new Task());
        }
        System.out.printf("Thread name: %s%n", Thread.currentThread().getName());
    }
}
