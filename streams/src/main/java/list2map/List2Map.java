package list2map;

import dao.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class List2Map {

    public static void main(String[] args) {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client(1, "Ivan", "Ivanov", 20));
        clients.add(new Client(2, "Petr", "Petrov", 25));
        clients.add(new Client(3, "Igor", "Igorev", 30));

        Map<Integer, String> clientsMap = IntStream.range(0, clients.size()).boxed().collect(Collectors.toMap(i -> ++i, i -> clients.get(i).getName()));
        clientsMap.entrySet().forEach(System.out::println);
    }
}
