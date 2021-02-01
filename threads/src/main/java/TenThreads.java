/**
 * inzheneher created on 31/01/2021 inside the package - PACKAGE_NAME
 */
public class TenThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread currentThread = new Thread(new Task());
            currentThread.start();
        }
        System.out.printf("Thread name: %s%n", Thread.currentThread().getName());
    }
}
