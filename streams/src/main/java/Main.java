import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Main.Client> list = new ArrayList<>();
        list.add(new Client("Ivan", "Ivanov"));
        list.add(new Client("Goga", "Shvanidze"));
        list.add(new Client("Grug", "Huntov"));
        list.add(new Client("Nerfip", "Mokin"));
        list.add(new Client("Buaod", "Podzemkin"));

        Map<String, Client> clientMap = list.stream().collect(Collectors.toMap(Client::getFirstName, client -> client));

        clientMap.entrySet().forEach(System.out::println);
    }

    static class Client {
        private String firstName;
        private String lastName;

        public Client(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }

}
