package leetcodeprep;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{3,3};
        int target = 6;
        TwoSum twoSum = new TwoSum();
        System.out.println("[" + twoSum.twoSum(nums,target)[0] + "," + twoSum.twoSum(nums,target)[1] + "]");
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        outerLoop: // Using label to break out of two loops at once
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break outerLoop;
                }
            }
        }
        return result;
    }
}
