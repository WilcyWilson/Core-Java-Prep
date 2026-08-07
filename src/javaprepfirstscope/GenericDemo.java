package javaprepfirstscope;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class GenericDemo {
    public static void main(String[] args) {
        // A list that just holds string
        List<String> names = new ArrayList<>(); // decoupling
        names.add("Spiderman");
        names.add("Batman");
        names.add("Ironman");

        // Functional Interface that takes String and returns its length
        Function<String,Integer> lambda = name -> name.length();

        // Method Reference instead of Lambdas
        Function<String, Integer> methodRef = String::length;

        // Applying above generics to every String
        for (String name: names) {
            Integer length = lambda.apply(name);
            Integer length2 = methodRef.apply(name);
            System.out.println(name + " has " + length + " letters.");
            System.out.println(name + " has " + length2 + " letters through method reference.");
        }
    }
}
