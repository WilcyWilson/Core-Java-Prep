package javaprepfirstscope;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

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
        String greeting = "Hello";
//        Supplier<Integer> boundMethodLambdaExpression = () -> greeting.length();
        // The object is already bound at the time the reference is created. The functional interface takes zero arguments because the receiver is fixed.
        Supplier<Integer> boundInstanceMethodReference = greeting::length;
        System.out.println(boundInstanceMethodReference.get());

        var list = new ArrayList<String>();
        Consumer<String> boundMethodConsumerMethodReference = list::add;
//        Consumer<String> lambdaExpressionConsumerMethodReference = item -> list.add(item);

        boundMethodConsumerMethodReference.accept("Spiderman");
        list.forEach(System.out::println);
    }
}
