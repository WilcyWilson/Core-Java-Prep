package javaprepfirstscope;

import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        // Types of Method reference
        // 1. Static method reference
        // Syntax: ClassName::staticMethod
        Function<Long, Long> mathAbsoluteMethodReference = Math::abs;
        // Function<Long, Long> mathAbsoluteLambdaExpression = num -> Math.abs(num);
        System.out.println(mathAbsoluteMethodReference.apply(-210323242524232L));

        Function<Integer, String> valueOfMethodReference = String::valueOf;
        // Function<Integer, String> valueOfLambdaExpression = a -> String.valueOf(a);
        System.out.println(valueOfMethodReference.apply(41));

        // 2. Unbound instance method reference
        // Syntax: Classname::instanceMethod
        Function<String, Integer> stringLengthMethodReference = String::length;
        // Function<String, Integer> stringLengthLambdaExpression = name -> name.length();
        System.out.println(stringLengthMethodReference.apply("Spiderman"));

        BiFunction<String, String, Integer> compareToMethodReference = String::compareTo;
        // BiFunction<String, String, Integer> compareToLambdaExpression = (a, b) -> a.compareTo(b);

        // calling string comes before argument string so negative integer result
        System.out.println(compareToMethodReference.apply("apple", "banana"));

        // 3. Bound Instance Method Reference
        // Syntax: instance::method


    }
}
