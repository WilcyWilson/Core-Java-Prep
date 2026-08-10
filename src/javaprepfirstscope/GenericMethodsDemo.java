package javaprepfirstscope;

import java.util.*;

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
        Arrays.stream(arr).forEach(element -> System.out.print(element + " "));

        System.out.println();
        // Consumer Generic accepts a single input argument of type T and returns no result (void)
        // Arrays.stream(arr).forEach(input -> System.out.println(input));
    }

    // Generic Method returning the type
    public static <T> T getFirst(T[] arr) {
        var stringArr = new ArrayList<String>();
        System.out.println();
        Arrays.stream(arr).forEach(element -> stringArr.add(element.toString()));
        stringArr.forEach(System.out::println);
        return arr.length > 0 ? arr[0] : null;
    }

    // Generic method with multiple bounds
    // T must be a class/object that implements the Comparable interface
    public static <T extends Comparable<T>> T findMax(T[] array) {
        if (array == null || array.length == 0) {
            return null;
//             Dereference of 'array' may produce 'NullPointerException'
//            return array.length;
        }

        return Arrays.stream(array).filter(Objects::nonNull).max(Comparator.naturalOrder()).orElse(null);
    }

    public static void main(String[] args) {
        var arr = new Integer[]{1, 2, 3, 4, 555, 55, 123, 222, 101};
        var arr2 = new Integer[20];
        printArray(arr);

        System.out.println("\n" + getFirst(arr) + "\n");

        // Find Max
        System.out.println(findMax(arr));

        System.out.println(findMax(arr2));
    }
}
