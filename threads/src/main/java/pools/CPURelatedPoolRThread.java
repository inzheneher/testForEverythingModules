package pools;

import utils.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * inzheneher created on 31/01/2021 inside the package - pools
 */
public class CPURelatedPoolRThread {
    public static void main(String[] args) {
        //get count of available cores
        int coreCount = Runtime.getRuntime().availableProcessors();
        //print number of cores
        System.out.printf("Number of cores is: %s%n", coreCount);
        ExecutorService service = Executors.newFixedThreadPool(coreCount);
        //submit the tasks for execution
        for (int i = 0; i < 100; i++) {
            service.execute(new Task());
        }
        System.out.printf("Thread name: %s%n", Thread.currentThread().getName());
    }
}
