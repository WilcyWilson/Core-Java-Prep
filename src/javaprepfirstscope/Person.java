package javaprepfirstscope;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Method reference comparator
public record Person(String name, int age, int salary) {

    public static void main(String[] args) {
        Person p1 = new Person("Clark", 36, 400000);
        Person p2 = new Person("Bruce", 36, 50000000);
        Person p3 = new Person("Barry", 25, 300000);
        Person p4 = new Person("Hal", 30, 400000);
        Person p5 = new Person("Diana", 1200, 5000000);
        Person p6 = new Person("Clark", 36, 300000);
        Person p7 = new Person("Bruce", 26, 30000000);


        List<Person> list = new ArrayList<>();

        list.add(p6);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p1);
        list.add(p7);

        List<Person> list2 = new ArrayList<>(list);
        List<Person> list3 = new ArrayList<>(list);
        List<Person> list4 = new ArrayList<>(list);
        List<Person> list5 = new ArrayList<>(list);

//        list.add(new Person(null, 0, 0)); // This will throw Null pointer exception since comparator doesn't handle null in this sort for person name
        list5.add(new Person(null, 0, 0));

        System.out.println("List without any sort:");
        list.forEach(System.out::println);
        System.out.println();

        System.out.println("Sorting by Name then age then salary:");
        list.sort(Comparator.comparing(Person::name).thenComparingInt(Person::age).thenComparingInt(Person::salary));
        list.forEach(System.out::println);
        System.out.println();

        System.out.println("Sorting by age then name then salary:");
        list2.sort(Comparator.comparingInt(Person::age).thenComparing(Person::name).thenComparingInt(Person::salary));
        System.out.println();
        list2.forEach(System.out::println);
        System.out.println();

        System.out.println("Sorting by age only:");
        list3.sort(Comparator.comparingInt(Person::age));
        System.out.println();
        list3.forEach(System.out::println);

        System.out.println();
        System.out.println("Reversing the salary order");
        list4.sort(Comparator.comparingInt(Person::salary).reversed());
        list4.forEach(System.out::println);

        System.out.println();
        System.out.println("Taking care of null conditon");
        list5.sort(Comparator.comparing(Person::name, Comparator.nullsLast(Comparator.naturalOrder())));
        list5.forEach(System.out::println);
    }
}
