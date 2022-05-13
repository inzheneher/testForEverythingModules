import interfaces.Worker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aleksandr Melnikov
 * created on 2022-05-04
 */
public class FibonacciList {
    public static void main(String[] args) {
        Worker<List<Integer>, Integer> fibonacci = (a) -> {
            List<Integer> fibonacciSeq = new ArrayList<>();
            if (a > 1) {
                fibonacciSeq.add(0);
                fibonacciSeq.add(1);
                for (int i = 2; i < a; i++) {
                    fibonacciSeq.add(fibonacciSeq.get(i - 2) + fibonacciSeq.get(i - 1));
                }
                return fibonacciSeq;
            } else if (a > 0) {
                fibonacciSeq.add(0);
                return fibonacciSeq;
            } else throw new IllegalArgumentException("The number must be > 0");
        };
        fibonacci.worker(15).forEach(System.out::println);
    }
}
