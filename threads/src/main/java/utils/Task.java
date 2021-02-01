package utils;

/**
 * inzheneher created on 01/02/2021 inside the package - utils
 */
public class Task implements Runnable {
    @Override
    public void run() {
        System.out.printf("Thread name: %s%n", Thread.currentThread().getName());
    }
}
