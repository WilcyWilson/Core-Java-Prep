package javaprepfirstscope;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FindEvenWithStream {
    public static void main(String[] args) {
        List<List<Integer>> nestedList = new ArrayList<>();
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

        for (int i = 0; i < 10; i++) {
            int randomInt = threadLocalRandom.nextInt(1, 501);
            nestedList.add(List.of(randomInt, randomInt + 1, randomInt + 2, randomInt + 3));
        }

        System.out.println("\nActual Collection Flattened");
        nestedList
                .stream()
                .flatMap(List::stream)
                .forEach(value -> System.out.print(value + " "));

        System.out.println("\nFinding the even");
        System.out.println(nestedList
                .stream()
                .flatMap(List::stream)
                .filter(n -> n % 2 == 0)
                .findFirst()
                .orElse(0));
    }
}
