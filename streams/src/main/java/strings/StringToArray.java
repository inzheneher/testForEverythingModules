package strings;

import java.util.List;
import java.util.stream.Collectors;

public class StringToArray {

    public static void main(String[] args) {

        int counter = 0;

        String string = "ifailuhkqq"; //ifailuhkqq = 3; abcdaba = ?; kkkk = 10;
        List<Character> characters = string
                .chars()
                .mapToObj(c -> (char) c)
                .sorted(Character::compareTo)
                .collect(Collectors.toList());
        characters
                .stream()
                .map(l -> l + " ")
                .forEach(System.out::print);
        System.out.println();

        for (int i = 0; i < characters.size() - 1; i++) {
            for (int j = i + 1; j < characters.size(); j++) {
                if (characters.get(i) == characters.get(j)) {
                    counter++;
                }
            }
        }

        System.out.println("Number of similar elements in array is: ".concat(String.valueOf(counter)));
    }
}
