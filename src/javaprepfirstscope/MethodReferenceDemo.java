package javaprepfirstscope;

import java.util.function.Function;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        // Types of Method reference
        // 1. Static method reference
        Function<Long, Long> mathAbsoluteMethodReference = Math::abs;
        Function<Long, Long> mathAbsoluteLambdaExpression = num -> Math.abs(num);
        System.out.println(mathAbsoluteMethodReference.apply(-210323242524232L));
    }
}
