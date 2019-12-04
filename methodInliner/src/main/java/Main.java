public class Main {

    public static void main(String[] args) {
        System.out.println("FIRST");
        String name = "";
        if (!(name = getName()).isEmpty() && name.length() > 3) {
            System.out.println("OK");
        }
        System.out.println("SECOND");
        if (!getName().isEmpty() && getName().length() > 3) {
            System.out.println("OK");
        }
    }

    private static String getName() {
        System.out.println("INSIDE METHOD!!!");
        return "name";
    }
}
