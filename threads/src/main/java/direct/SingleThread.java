package direct;

import utils.Task;

/**
 * inzheneher created on 31/01/2021 inside the package - direct
 */
public class SingleThread {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task());
        thread1.start();
        System.out.printf("Thread name: %s%n", Thread.currentThread().getName());
    }
}
