import java.util.Arrays;

public class PrintArrayWithStream {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 2, 5, 7, 4, 7, 2, 8, 5};

        Arrays.stream(arr).forEach(result -> System.out.print(result + " "));
    }
}
