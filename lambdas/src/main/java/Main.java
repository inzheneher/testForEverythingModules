import interfaces.IFunction;

/**
 * inzheneher created on 28/12/2020 inside the package - PACKAGE_NAME
 */
public class Main {
    public static void main(String[] args) {
        //get a factorial using lambda
        IFunction<Integer, Integer> number = (a) -> {
            int result = 1;
            for (int i = 1; i <= a; i++) result = i * result;
            return result;
        };
        final int b = 5;
        System.out.printf("%s! = %s\n", b,  number.function(b));
        //get reverse a string using lambda
        IFunction<String, String> reverser = (a) -> {
            StringBuilder result = new StringBuilder();
            for (int i = a.length() - 1; i >= 0 ; i--) result.append(a.charAt(i));
            return result.toString();
        };
        final String word = "ATMOSPHERE";
        System.out.printf("%s reverse = %s\n", word, reverser.function(word));
        //check if a number is odd or even
        IFunction<Boolean, Integer> oddOrEvenChecker = a -> a % 2 == 0;
        final int x = 57;
        final int y = 66;
        isNumberOdd(oddOrEvenChecker, x);
        isNumberOdd(oddOrEvenChecker, y);
    }

    private static void isNumberOdd(IFunction<Boolean, Integer> oddOrEvenChecker, int number) {
        if (oddOrEvenChecker.function(number)) System.out.printf("%s is even", number);
        else System.out.printf("%s is odd\n", number);
    }
}
