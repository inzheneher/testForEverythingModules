/**
 * inzheneher created on 14/05/2020 inside the package - default
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(getFibonacciNumberOnPosition(10));
    }

    private static int getFibonacciNumberOnPosition(int number) {
        if (number == 0) return 0;
        else if (number == 1 || number == 2) return 1;
        else return getFibonacciNumberOnPosition(number - 2) + getFibonacciNumberOnPosition(number - 1);
    }
}
