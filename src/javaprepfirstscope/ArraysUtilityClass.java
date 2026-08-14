package javaprepfirstscope;

import java.util.Arrays;

public class ArraysUtilityClass {
    public static void main(String[] args) {
        // Algorithm for primitives: Dual-Pivot Quicksort since Java 7
        int[] arr = {15, 10, 30, 23, 24};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        // For objects (not primitives), Timsort
        String[] string = {"banana", "apple"};
        Arrays.sort(string);
        System.out.println(Arrays.toString(string));

        // Binary search - arrays must be sorted first
        // [10, 15, 23, 24 (Position 4), 30] arr after sort
        System.out.println(Arrays.binarySearch(arr, 24));
        System.out.println(Arrays.binarySearch(arr, 25)); // -4(Insertion Point) - 1 = -5 // No conflict to index 0
    }
}
