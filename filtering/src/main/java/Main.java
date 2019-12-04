import model.Client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date currentDate = new Date();

        List<Client> clientList = new ArrayList<>();
        try {
            clientList.add(new Client("Fui", "Oyi", sdf.parse("1951-04-25"), 12));
            clientList.add(new Client("Qop", "Lun", sdf.parse("1968-05-17"), 23));
            clientList.add(new Client("Mer", "Jid", sdf.parse("1977-10-03"), 37));
            clientList.add(new Client("Rij", "Hap", sdf.parse("1990-12-10"), 64));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Client> clientListFiltered = clientList.stream()
                .filter(client -> client.getAge() > 18 && client.getDob().after(currentDate))
                .collect(Collectors.toList());

        System.out.println(currentDate);
        clientListFiltered.forEach(System.out::println);
    }
}
