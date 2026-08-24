package javaprepfirstscope;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record PersonCollection(String name, String city, int salary) {

    public static void main(String[] args) {
        List<PersonCollection> personCollectionList = createPersonCollectionList();

        System.out.println("\nGrouping without Downstream results in the List<Classname>\n");

        Map<String, List<PersonCollection>> stringListMap = personCollectionList
                .stream()
                .collect(Collectors.groupingBy(PersonCollection::city));

        stringListMap.forEach((a, b) -> {
            System.out.print(a);
            System.out.println(b);
        });

        System.out.println("\nGrouping with Downstream and adding a delimiter to convert to String\n");

        Map<String, String> stringStringMap = personCollectionList
                .stream()
                .collect(Collectors.groupingBy(PersonCollection::city, Collectors.mapping(PersonCollection::name, Collectors.joining(","))));

        stringStringMap.forEach((city, name) -> {
            System.out.print(city + " - ");
            System.out.println(name);
        });

        System.out.println("\nGrouping with Downstream and converting the resulting names to List\n");

        Map<String, List<String>> stringStringListMap = personCollectionList
                .stream()
                .collect(Collectors.groupingBy(PersonCollection::city, Collectors.mapping(PersonCollection::name, Collectors.toList())));

        stringStringListMap.forEach((city, name) -> {
            System.out.print(city + " - ");
            System.out.println(name);
        });

        System.out.println("\nGrouping with Downstream and averaging the salary\n");

        Map<String, Double> stringDoubleMap = personCollectionList
                .stream()
                .collect(Collectors.groupingBy(PersonCollection::city, Collectors.averagingInt(PersonCollection::salary)));

        stringDoubleMap.forEach((city, average) -> {
            System.out.print(city + " - ");
            System.out.println(average);
        });

        System.out.println("\nGrouping by city and Partitioning people with salary higher than 30000\n");

        Map<String, Map<Boolean, List<PersonCollection>>> booleamapMap = personCollectionList
                .stream()
                .collect(Collectors.groupingBy(PersonCollection::city, Collectors.partitioningBy(p -> p.salary > 30000)));

        booleamapMap.forEach((city, map) -> {
            System.out.print(city + " - ");
            System.out.println(map);
        });

        System.out.println("\nPartitioning people with salary higher than 30000 and showing their names\n");

        Map<Boolean, String> booleanStringMap = personCollectionList
                .stream()
                .collect(Collectors.partitioningBy(p -> p.salary > 30000, Collectors.mapping(PersonCollection::name, Collectors.joining(","))));

        booleanStringMap.forEach((condition, name) -> {
            System.out.print(condition + " - ");
            System.out.println(name);
        });

        System.out.println("\nPartitioning people with salary higher than 30000 and showing their name and city\n");

        Map<Boolean, String> booleanStringMap2 = personCollectionList
                .stream()
                .collect(Collectors.partitioningBy(p -> p.salary > 30000, Collectors.mapping(collection -> collection.city() + '=' + collection.name(), Collectors.joining(","))));

        booleanStringMap2.forEach((condition, name) -> {
            System.out.print(condition + " - ");
            System.out.println(name);
        });


    }

    private static List<PersonCollection> createPersonCollectionList() {
        List<PersonCollection> personCollectionList = new ArrayList<>();
        personCollectionList.add(new PersonCollection("Hal", "Kathmandu", 50000));
        personCollectionList.add(new PersonCollection("Bruce", "Gotham", 500000));
        personCollectionList.add(new PersonCollection("Barry", "Gotham", 30000));
        personCollectionList.add(new PersonCollection("Clark", "Washington", 40000));
        personCollectionList.add(new PersonCollection("Steven", "Kathmandu", 100000));
        personCollectionList.add(new PersonCollection("Hulk", "New York", 300000));
        personCollectionList.add(new PersonCollection("Diana", "California", 100000));
        personCollectionList.add(new PersonCollection("Luther", "Washington", 500000));
        personCollectionList.add(new PersonCollection("Brock", "California", 5000));
        personCollectionList.add(new PersonCollection("Clint", "San Francisco", 25000));
        personCollectionList.add(new PersonCollection("Natasha", "San Francisco", 25000));
        return personCollectionList;
    }
}
