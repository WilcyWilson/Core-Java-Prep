package javaprepfirstscope;

import java.util.Arrays;

public class ArraysUtilityClass{
    public static void main(String[] args) {
        // Algorithm for primitives: Dual-Pivot Quicksort since Java 7
        int[] arr = {15,10,30,23,24};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        // For objects (not primitives), Timsort
        String[] string = {"banana", "apple"};
        Arrays.sort(string);
        System.out.println(Arrays.toString(string));
    }
}
