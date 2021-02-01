/**
 * inzheneher created on 31/01/2021 inside the package - PACKAGE_NAME
 */
public class Task implements Runnable {
    @Override
    public void run() {
        System.out.printf("Thread name: %s%n", Thread.currentThread().getName());
    }
}
