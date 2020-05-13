/**
 * inzheneher created on 13/05/2020 inside the package - PACKAGE_NAME
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println(getFactorialOf(5));
    }

    private static int getFactorialOf(int number) {
        if (number == 0) return 1;
        else return number * getFactorialOf(number - 1);
    }
}
