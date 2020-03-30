package strings;

public class StringToArray {

    public static void main(String[] args) {

        int counter = 0;

        String string = "ifailuhkqq"; //ifailuhkqq = 3; abcdaba = ?; kkkk = 10;

        for (int i = 0; i < string.length() - 1; i++) {
            for (int j = i + 1; j < string.length(); j++) {
                if (string.substring(i, i + 1).equals(string.substring(j, j + 1))) {
                    counter++;
                }
            }
        }

        System.out.println("Number of similar elements in array is: ".concat(String.valueOf(counter)));
    }
}
