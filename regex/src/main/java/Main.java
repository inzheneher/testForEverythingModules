import java.util.regex.Pattern;

/**
 * inzheneher created on 26/01/2021 inside the package - PACKAGE_NAME
 */
public class Main {
    private final static String IP4V_REGEX = "(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    private final static String IP6V_REGEX = "(([0-9a-fA-F]{1,4}):){7}([0-9a-fA-F]{1,4})";

    public static void main(String[] args) {
        System.out.printf("First input is: %s%n", validIPAddress("192.168.255.1"));
        System.out.printf("Second input is: %s", validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
    }

    public static String validIPAddress(String IP) {
        Pattern patIP4 = Pattern.compile(IP4V_REGEX);
        Pattern patIP6 = Pattern.compile(IP6V_REGEX);
        if (patIP4.matcher(IP).matches()) return "IPv4";
        return patIP6.matcher(IP).matches()? "IPv6" : "Neither";
    }
}
