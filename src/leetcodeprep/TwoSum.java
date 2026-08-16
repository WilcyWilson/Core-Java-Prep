package leetcodeprep;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 18;
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(nums, target);

        System.out.println("[" + result[0] + "," + result[1] + "]");

        result = twoSum.twoSumHashMap(nums, target);
        System.out.println("[" + result[0] + "," + result[1] + "]");
        result = twoSum.twoSumStream(nums, target);
        System.out.println("[" + result[0] + "," + result[1] + "]");
    }

    // Higher time complexity, lower space complexity. Time Complexity - O(n) x O(n) = O (n²)
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    // Higher time complexity, lower space complexity. Time Complexity - O(n) x O(n) = O (n²)
    // Super slow due to boxing and unboxing
    public int[] twoSumStream(int[] nums, int target) {

        return IntStream.range(0, nums.length).
                boxed().
                flatMap(i ->
                        IntStream.range(i + 1, nums.length).
                                filter(j -> nums[i] + nums[j] == target).
                                mapToObj(j -> new int[]{i, j})).
                findFirst().
                orElse(new int[]{0, 0});
    }

    // Lower time complexity, higher space complexity. Time Complexity - O(1) x O(n) = O (n)
    public int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> numsHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int searchInt = target - nums[i];
            if (numsHashMap.containsKey(searchInt)) {
                return new int[]{numsHashMap.get(searchInt), i};
            }
            numsHashMap.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
}
