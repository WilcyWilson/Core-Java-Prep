package leetcodeprep.twopointers;

import java.util.Arrays;

public class SquaresOfASortedArray {

    // Bruteforce
    public int[] sortedSquaresBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public int[] sortedSquaresLoops(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        int left = 0;
        int right = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[left] > nums[right]) {
                result[i] = nums[left];
                left++;
            } else {
                result[i] = nums[right];
                right--;
            }
        }
        return result;
    }

    public int[] sortedSquaresOptimized(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[i] = nums[left] * nums[left];
                left++;
            } else {
                result[i] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SquaresOfASortedArray().sortedSquaresBruteForce(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(new SquaresOfASortedArray().sortedSquaresLoops(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(new SquaresOfASortedArray().sortedSquaresLoops(new int[]{-7, -3, 2, 3, 11})));
        System.out.println(Arrays.toString(new SquaresOfASortedArray().sortedSquaresOptimized(new int[]{-7, -3, 2, 3, 11})));

    }
}
