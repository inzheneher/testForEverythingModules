import java.util.Arrays;

public class StringToArray {

    public static void main(String[] args) {

        int counter = 0;

        String string = "abcdaba"; //ifailuhkqq = 3; abcdaba = ?; kkkk = 10; cdcd = 5;

        try {

            for (int k = 0; k < string.length() - 1; k++) {
                for (int i = 0; i < string.length() - 1; i++) {
                    for (int j = i + 1; j < string.length() - k; j++) {
                        String substring1 = string.substring(i, i + 1 + k);
                        String substring2 = string.substring(j, j + 1 + k);

                        char[] subStrChar1 = substring1.toCharArray();
                        char[] subStrChar2 = substring2.toCharArray();

                        Arrays.sort(subStrChar1);
                        Arrays.sort(subStrChar2);

                        if (Arrays.equals(subStrChar1, subStrChar2)) {
                            System.out.println(subStrChar1);
                            System.out.println(subStrChar2);
                            counter++;
                        }
                    }
                }
            }

            System.out.println("Number of similar elements in array is: ".concat(String.valueOf(counter)));

        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
