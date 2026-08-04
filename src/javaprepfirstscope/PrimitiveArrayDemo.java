package javaprepfirstscope;

public class PrimitiveArrayDemo {
    public static void main(String[] args) {
        byte[] a = new byte[10];
        /* byte b[] = new byte[20];*/ // C style array type declaration, not preferred
        int[] b, c; // both are int array. Accepted
        int d[], e; // d is int array and e is just int.  C style not preferred
        int[] f, g[]; // f is int array and g is int[][] array. C style not preferred
        a[0] = 1;
        a[1] = 2;
        System.out.println(a[1]);

        int[] arr = new int[10]; // initialization. All elements are zero initialized
        int[] arr2 = {10, 20, 30}; // Compiler infers size = 3

        // Anonymous array ( required when declaring after the fact)
        int[] arr3;
        arr3 = new int[]{10, 20, 30};

        System.out.println(arr3[2]);

        // Empty array
        int[] arr4 = new int[0]; // valid object. length = 0
//        arr4.length = 5; // Error. length is final

        // Dynamic Sizing
        int size = 5;
        int[] arr5 = new int[size]; // Size can be variable/expression

        // Arrays are objects
        int[] arr6 = new int[5];
        System.out.println(arr5 instanceof Object); // true
        System.out.println(arr6.getClass().getSuperclass()); // Object class

        // Multidimensional arrays
        int[][] matrix1 = new int[3][4]; // array of 3 references and then 3 separate int[4] arrays

        // Each row can have different length
        int[][] jagged = new int[3][];
        jagged[0] = new int[4];
        jagged[1] = new int[3];
        jagged[2] = new int[4];

        int[] arr7 = {10, 20, 30, 40, 50};
        System.out.println(arr7[4]);
        /*System.out.println(arr7[5]);*/ // Array Out of bounds, runtime error

        // When you need index
        for (int i = 0; i < arr7.length; i++) {
            System.out.println("Index " + i + ": " + arr7[i]);
        }

        // When you need values
        for (int value : arr7) {
            System.out.println(value);
        }

        // While loop ( rarely used for arrays )
        int i = 0;
        while (i < arr7.length) {
            System.out.println("Index " + i + ": " + arr7[i++]);
        }
    }
}

