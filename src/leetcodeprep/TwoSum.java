package leetcodeprep;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 18;
        TwoSum twoSum = new TwoSum();

        try {
            int[] result = twoSum.twoSum(nums, target);

            System.out.println("[" + result[0] + "," + result[1] + "]");

            result = twoSum.twoSumHashMap(nums, target);
            System.out.println("[" + result[0] + "," + result[1] + "]");
            result = twoSum.twoSumStream(nums, target);
            System.out.println("[" + result[0] + "," + result[1] + "]");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
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
        throw new IllegalArgumentException("Two sum solution not found for " + target);
    }

    // Higher time complexity, lower space complexity. Time Complexity - O(n) x O(n) = O (n²)
    // Super slow due to boxing and unboxing
    public int[] twoSumStream(int[] nums, int target) {

        return IntStream.range(0, nums.length).parallel().
                boxed(). // box every int to Integer
                        flatMap(i -> // create a stream per element
                        IntStream.range(i + 1, nums.length).
                                filter(j -> nums[i] + nums[j] == target). // box again
                                mapToObj(j -> new int[]{i, j})). // box i and j again
                        findAny().
                orElseThrow(() -> new IllegalArgumentException("Two sum solution not found for " + target));
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
        throw new IllegalArgumentException("Two sum solution not found for " + target);
    }
}
