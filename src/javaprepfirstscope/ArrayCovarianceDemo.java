package javaprepfirstscope;

public class ArrayCovarianceDemo {
    public static void main(String[] args) {

        // Integer[] is a subtype of Number[]
        Integer[] intArray = {10, 20, 30};
        Number[] numArray = intArray; // Allowed


        System.out.println(numArray[0]);


        // Compiler allows it. JVM rejects it
        try {
            numArray[0] = 3.14; // Double is a Number, so compiler accepts this
        } catch (ArrayStoreException e) {
            System.out.println("Error Caught: " + e.getMessage());
        }
    }
}
