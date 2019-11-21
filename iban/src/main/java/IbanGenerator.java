import org.iban4j.Iban;

public class IbanGenerator {
    public static void main(String[] args) {
        System.out.println(Iban.random().toString());
    }
}
