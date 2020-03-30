package strings;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class RegexStreamTest {

    public static void main(String[] args) {
//1 2 2 3 1 2
        List<Integer> integerList = Stream.of("4 6 5 3 3 1".replaceAll("\\s{2,}", " ").trim().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(toList());

        List<Integer> tempList = new ArrayList<>();
        List<List<Integer>> subArrayList = new ArrayList<>();

        for (int i = 0; i < integerList.size(); i++) {
            if (tempList.size() > 0) {
                if (integerList.get(i) - tempList.get(0) > 1) {
                    subArrayList.add(tempList);
                    tempList = new ArrayList<>();
                }
                if (i + 1 == integerList.size()) {
                    tempList.add(integerList.get(i));
                    subArrayList.add(tempList);
                    break;
                }
            }
            tempList.add(integerList.get(i));
        }

        subArrayList.sort(Comparator.comparingInt(List::size));

        System.out.println(subArrayList);
        System.out.println(subArrayList.get(subArrayList.size() - 1).size());
    }
}
