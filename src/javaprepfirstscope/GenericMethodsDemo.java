package javaprepfirstscope;

import java.util.Arrays;

public class GenericMethodsDemo {
    private final Integer value1;
    private final Integer value2;

    GenericMethodsDemo(Integer value1, Integer value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    // Generic Method with Single Type
    public static <T> void printArray(T[] arr) {
        // containingObject::instanceMethodName
        Arrays.stream(arr).forEach(System.out::println);

        // Consumer Generic accepts a single input argument of type T and returns no result (void)
        // Arrays.stream(arr).forEach(input -> System.out.println(input));
    }

    public static void main(String[] args) {
        var arr = new Integer[]{1, 2, 3, 4, 5};
        printArray(arr);
    }
}
