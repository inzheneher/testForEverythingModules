public class Killer {

    private static boolean isCrazyMurderingRobot = false;

    public static void main(String[] args) {
        if (isCrazyMurderingRobot = true) {
            kill();
        } else {
            beNiceToHuman();
        }
    }

    private static void beNiceToHuman() {
        System.out.println("My Master!!!");
    }

    private static void kill() {
        System.out.println("One more person was just killed!!!");
    }
}
