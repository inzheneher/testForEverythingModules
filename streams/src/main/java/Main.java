import dao.Client;
import dao.ClientName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Client> list = new ArrayList<>();
        list.add(new Client(1, "Ivan", "Ivanov", 18));
        list.add(new Client(2, "Goga", "Shvanidze", 23));
        list.add(new Client(3, "Grug", "Huntov", 35));
        list.add(new Client(4, "Nerfip", "Mokin",42));
        list.add(new Client(5, "Buaod", "Podzemkin", 57));

        List<String[]> nameCharacters = new ArrayList<>();
        list.forEach(a -> nameCharacters.add(a.getName().split("")));

        //get list with type ClientName using map
        Stream<ClientName> clientNameStream = list.stream().map(a -> new ClientName(a.getName(), a.getLastName()));
        clientNameStream.forEach(a -> System.out.printf("%s %s%n", a.getName(), a.getLastName()));
        //get list with type ClientName using flatMap
        List<String> nameCharactersArray = nameCharacters.stream().flatMap(Stream::of).collect(Collectors.toList());
        nameCharactersArray.forEach(System.out::println);
    }
}
