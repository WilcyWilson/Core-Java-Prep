package javaprepfirstscope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalInterfaceBuild {

    public <T> List<T> filter(List<T> listOfValues, Predicate<T> condition) {
        List<T> resultListOfValues = new ArrayList<>();
        for (T value : listOfValues) {
            if (condition.test(value)) {
                resultListOfValues.add(value);
            }
        }
        return resultListOfValues;
    }

    public static void main(String[] args) {
        List<String> heroes = new ArrayList<>(Arrays.asList("Spider", "Platic Man", "Ironman", "Batman", "Superman", "Batman 2099"));
        new FunctionalInterfaceBuild().filter(heroes, hero -> !hero.contains("Batman")).forEach(System.out::println);

        System.out.println();
        List<Integer> powerLevels = new ArrayList<>(Arrays.asList(80, 90, 50, 20, 100));
        new FunctionalInterfaceBuild().filter(powerLevels, power -> power > 50).forEach(System.out::println);
    }

}
