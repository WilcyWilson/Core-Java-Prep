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

    // Generic Method with Unknown type Unbounded wildcard
    public static void printList(List<?> list) {
        list.forEach(System.out::println);
    }

    // Generic Method with Upper bounded wildcard
    // Accepts List of Double, Float, Integer
    // Producer
    public static double sumOfList(List<? extends Number> value) {
        return value.stream().mapToDouble(Number::doubleValue).sum();
    }

    // Generic Method with Lower bounded wildcard
    // holds elements of some unknown type that is a superclass (or the type itself) of Integer.
    // Consumer
    public static void addToList(List<? super Number> value) {
        // The Allowed Arguments to .add(): Can only be Number or its subclasses (Integer, Double).
        value.add(21);
        value.add(100);
        value.add(3.14);
//        value.add(new Object()); // Error
    }

    public static void main(String[] args) {
        var arr = new Integer[]{1, 2, 3, 4, 555, 55, 123, 222, 101};
        var arr2 = new Integer[20];
        printArray(arr);

        System.out.println("\n" + getFirst(arr) + "\n");

        // Find Max
        System.out.println(findMax(arr));

        System.out.println(findMax(arr2));

        List<String> stringList = new ArrayList<>();
        stringList.add("\nBatman");
        stringList.add("Superman");
        stringList.add("Ironman\n");
        printList(stringList);

        List<Integer> integerList = new ArrayList<>();
        integerList.add(21);
        integerList.add(66);
        integerList.add(78);

        List<Double> doubleList = Arrays.asList(112.1, 2534.55, 323.3);
        System.out.println(sumOfList(integerList));
        System.out.println(sumOfList(doubleList));

        List<Number> numbers = new ArrayList<>();
        addToList(numbers);

        List<Object> objects = new ArrayList<>();
        addToList(objects);

        // The List's Allowed Runtime Types: Can only be Number or its superclasses (Object).
//        List<Integer> integers = new ArrayList<>();
//        addToList(integers); // Error
//
//        List<Double> doubles = new ArrayList<>();
//        addToList(doubles); // Error
    }
}
