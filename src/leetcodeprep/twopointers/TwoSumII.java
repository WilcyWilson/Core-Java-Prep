package leetcodeprep.twopointers;

import java.util.Arrays;

// Two Pointers
public class TwoSumII {

    //Mine
    public int[] twoSumLoop(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }

    // Best
    public int[] twoSumWhile(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSumII().twoSumLoop(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(new TwoSumII().twoSumLoop(new int[]{2, 3, 4}, 7)));
        System.out.println(Arrays.toString(new TwoSumII().twoSumLoop(new int[]{-1, 0}, -1)));
        System.out.println(Arrays.toString(new TwoSumII().twoSumLoop(new int[]{18, 21, 66, 201}, 12)));

        System.out.println();
        System.out.println(Arrays.toString(new TwoSumII().twoSumWhile(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(new TwoSumII().twoSumWhile(new int[]{2, 3, 4}, 7)));
        System.out.println(Arrays.toString(new TwoSumII().twoSumWhile(new int[]{-1, 0}, -1)));
        System.out.println(Arrays.toString(new TwoSumII().twoSumWhile(new int[]{18, 21, 66, 201}, 12)));


    }
}
