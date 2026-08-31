package javaprepfirstscope;

import java.util.Optional;

public class OptionalOrElseDemo {
    public static String getExpensiveFallback() {
        System.out.println("Executing getExpensiveFallback()");
        return "Fallback Value";
    }

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Real Value");
        System.out.println("Testing orElse");
        // Eager (function called even when Optional is not empty leaving only the return value as it is)
        String result = optional.orElse(getExpensiveFallback()); // Eager
        System.out.println("Result1: " + result);

        Optional<String> optionalEmpty = Optional.empty();
        System.out.println("\nTesting orElse with Empty");
        String resultEmpty = optionalEmpty.orElse(getExpensiveFallback()); // Eager
        System.out.println("Result2: " + resultEmpty);

        System.out.println("\nTesting orElseGet");
        // Lazy (function called only when Optional is empty)
        String result2 = optional.orElseGet(OptionalOrElseDemo::getExpensiveFallback);
        System.out.println("Result3:" + result2);

        System.out.println("\nTesting orElseGet with Empty");
        String resultOrElseGetEmpty = optionalEmpty.orElseGet(OptionalOrElseDemo::getExpensiveFallback); // Lazy
        System.out.println("Result4:" + resultOrElseGetEmpty);
    }
}
