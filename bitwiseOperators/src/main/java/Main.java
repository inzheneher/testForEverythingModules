public class Main {

    public static void main(String[] args) {

        int a, b, c;
        a = 10873;
        b = 13482;

        c = add(a, b);
        System.out.println(c + " " + (a + b));
    }

    private static int add(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return add(a ^ b, (a & b) << 1);
        }
    }
}
