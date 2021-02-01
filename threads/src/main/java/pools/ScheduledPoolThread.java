package pools;

import utils.Task;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * inzheneher created on 31/01/2021 inside the package - pools
 */
public class ScheduledPoolThread {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        service.schedule(new Task(), 10, MILLISECONDS);
        service.scheduleAtFixedRate(new Task(), 15, 10, MILLISECONDS);
        service.scheduleWithFixedDelay(new Task(), 15, 10, MILLISECONDS);
        System.out.printf("Thread name: %s%n", Thread.currentThread().getName());
    }
}
