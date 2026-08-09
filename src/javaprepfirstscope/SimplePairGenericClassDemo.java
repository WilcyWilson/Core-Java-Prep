package javaprepfirstscope;

import java.util.Objects;
import java.util.function.Function;

public class SimplePairGenericClassDemo<K, V> {
    private final K key;
    private final V value;

    public SimplePairGenericClassDemo(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public static void checkLength(SimplePairGenericClassDemo<String, Integer> obj) {
        Function<String, Integer> func = String::length;
        if (Objects.equals(func.apply(obj.getKey()), obj.getValue())) {
            System.out.println("The length '" + obj.getValue() + "' of the given String '" + obj.getKey() + "' is correct\n");
        } else {
            System.out.println("The length '" + obj.getValue() + "' of the given String '" + obj.getKey() + "' is incorrect\n");
        }
    }

    @Override
    public String toString() {
        return "Key: " + key + "\nValue: " + value + "\n";
    }

    public static void main(String[] args) {
        SimplePairGenericClassDemo<String, Integer> obj = new SimplePairGenericClassDemo<>("Spiderman", 9);
        SimplePairGenericClassDemo<String, Integer> obj2 = new SimplePairGenericClassDemo<>("Batman", 5);
        System.out.println(obj);
        System.out.println(obj2);

        checkLength(obj);
        checkLength(obj2);

        SimplePairGenericClassDemo<String, String> obj3 = new SimplePairGenericClassDemo<>("Iron", "Man");
        System.out.println(obj3);

        // Required type won't match. Incompatible type compile time error
        // checkLength(obj3);

    }
}
