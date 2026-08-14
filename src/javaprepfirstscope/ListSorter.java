package javaprepfirstscope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSorter {

    public static List<String> sorter(List<String> stringList){
        return stringList.stream().sorted().toList();
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(Arrays.asList("Hello", "Spider", "Chocolate", "Max", "Red", "Hell"));
        System.out.println("Before Sort:");
        stringList.forEach(System.out::println);

        // Using Stream
        SortList sortListStream = new SortList() {
            @Override
            public List<String> sortedResult(List<String> stringList) {
                return stringList.stream().sorted().toList();
            }
        };
        System.out.println("\nAfter Sort using Anonymous Class Stream:");
        sortListStream.sortedResult(stringList).forEach(System.out::println);

        // Using Lambda Expression
        SortList sortListLambda = stringListLambda -> stringListLambda.stream().sorted().toList();
        System.out.println("\nAfter Sort using Lambda Expression Stream:");
        sortListLambda.sortedResult(stringList).forEach(System.out::println);

        // Using method reference
        SortList sortListMethodReference = ListSorter::sorter;
        System.out.println("\nAfter Sort using Method Expression Stream:");
        sortListMethodReference.sortedResult(stringList).forEach(System.out::println);

        System.out.println("\nChecking if it gets mutated using stream:");
        stringList.forEach(System.out::println);

        // Overcomplicating things Using Loops
        SortList sortListLoop = new SortList() {
            @Override
            public List<String> sortedResult(List<String> stringList) {
                for (int q = 0; q < stringList.size(); q++) {
                    stringList.set(q, stringList.get(q).toUpperCase());
                }
                System.out.println("\nIn uppercase:");
                stringList.forEach(System.out::println);

                List<String> sortedString = new ArrayList<>(stringList);
                System.out.println("\nAfter Sort using Loops:");
                for (int i = 0; i < sortedString.size(); i++) {
                    if (i > 0) {
                        stringList.remove(sortedString.get(i - 1));
                    }
                    for (int j = 0; j < stringList.size(); j++) {
                        for (int k = 0; k < sortedString.get(i).length(); k++) {
                            try {
                                sortedString.get(i).charAt(k);
                            } catch (IndexOutOfBoundsException e) {
                                sortedString.set(i, sortedString.get(i) + '\u0000');
                            }
                            try {
                                stringList.get(j).charAt(k);
                            } catch (IndexOutOfBoundsException e) {
                                stringList.set(j, stringList.get(j) + '\u0000');
                            }
                            if (sortedString.get(i).charAt(k) == stringList.get(j).charAt(k)) {
                                continue;
                            }
                            if (sortedString.get(i).charAt(k) < stringList.get(j).charAt(k)) {
                                sortedString.set(i, sortedString.get(i));
                                break;
                            } else {
                                String temp = sortedString.get(i);
                                if (sortedString.contains(stringList.get(j))) {
                                    sortedString.set(sortedString.indexOf(stringList.get(j)), temp);
                                }
                                sortedString.set(i, stringList.get(j));
                                break;
                            }
                        }
                    }
                }
                return sortedString;
            }
        };

        sortListLoop.sortedResult(stringList).forEach(System.out::println);

    }
}
