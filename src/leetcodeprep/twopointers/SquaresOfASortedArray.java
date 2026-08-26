package leetcodeprep.twopointers;

import java.util.Arrays;

public class SquaresOfASortedArray {

    // Bruteforce
    public int[] sortedSquaresBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SquaresOfASortedArray().sortedSquaresBruteForce(new int[]{-4, -1, 0, 3, 10})));
    }
}
