package javaprepfirstscope;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceBuild {

    public static final int HALF_POWER = 50;
    public static final int POWER_INCREASE_THRESHOLD = 10;
    public static final int FULL_POWER = 100;

    public static <T> List<T> filterCustom(List<T> listOfValues, Predicate<T> condition) {
        List<T> resultListOfValues = new ArrayList<>();
        for (T value : listOfValues) {
            if (condition.test(value)) {
                resultListOfValues.add(value);
            }
        }
        return resultListOfValues;
    }

    public static <T> void forEachCustom(List<T> listOfValues, Consumer<T> action) {
        for (T value : listOfValues) {
            action.accept(value);
        }
    }

    public static <T, R> List<R> mapCustom(List<T> listOfValues, Function<T, R> transformer) {
        List<R> returnValue = new ArrayList<>();
        for (T value : listOfValues) {
            returnValue.add(transformer.apply(value));
        }
        return returnValue;
    }

    public static <T> T supplierCustom(Supplier<T> supply) {
        return supply.get();
    }

    public static void main(String[] args) {
        List<String> heroes = new ArrayList<>(Arrays.asList("Spider", "Plastic Man", "Ironman", "Batman", "Superman", "Batman 2099"));
        filterCustom(heroes, hero -> !hero.contains("Batman")).forEach(System.out::println);

        System.out.println();
        List<Integer> powerLevels = new ArrayList<>(Arrays.asList(80, 90, 50, 20, 100, 70));
        filterCustom(powerLevels, power -> power > HALF_POWER).forEach(System.out::println);

        System.out.println();
        forEachCustom(heroes, System.out::println);

        System.out.println();
        forEachCustom(powerLevels, power -> System.out.println(power + POWER_INCREASE_THRESHOLD > FULL_POWER ? power : power + POWER_INCREASE_THRESHOLD));

        System.out.println();
        mapCustom(heroes, String::length).forEach(System.out::println);

        String hero = supplierCustom(() -> "Spider-Man");
        System.out.println(hero);
    }

}
