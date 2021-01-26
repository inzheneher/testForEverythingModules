import java.util.Scanner;

/**
 * inzheneher created on 07/01/2021 inside the package - PACKAGE_NAME
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("For exit type 'exit'.\nEnter first number if you want to continue.");
        Scanner sc = new Scanner(System.in);
        String firstNumber;
        String operator;
        String secondNumber;
        int result;
        getNumber(sc);
        System.out.println("For exit type 'exit'.\nEnter operator.");
        while (true) {
            operator = sc.next();
            if (operator.equals("exit")) return;
            try {
                if (!operator.matches("[+*/-]")) throw new IllegalArgumentException("Incorrect data format. Redo.");
                else break;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        System.out.println("For exit type 'exit'.\nEnter second number if you want to continue.");
        getNumber(sc);
        switch (operator) {
            case "+":
                result = Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber);
                break;
            case "-":
                result = Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber);
                break;
            case "*":
                result = Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber);
                break;
            case "/":
                result = Integer.parseInt(firstNumber) / Integer.parseInt(secondNumber);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
        System.out.printf("Result is: %s", result);
    }

    private static void getNumber(Scanner sc) {
        while (true) {
            String number = sc.next();
            if (number.equals("exit")) return;
            try {
                if (!number.matches("\\d+")) throw new IllegalArgumentException("Incorrect data format. Redo.");
                else break;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }
}
