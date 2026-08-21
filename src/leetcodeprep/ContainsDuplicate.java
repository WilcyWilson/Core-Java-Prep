package leetcodeprep;

import java.util.*;

public class ContainsDuplicate {

    // TLE
    public boolean containsDuplicateLoops(int[] nums) {
        int[] numsCopy = new int[nums.length];
        System.arraycopy(nums, 0, numsCopy, 0, nums.length);
        int last = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (numsCopy[j] == numsCopy[i]) {
                    return true;
                }
                if (last != j) {
                    if (numsCopy[j] == numsCopy[last - 1 < 0 ? last : last--]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Accepted
    public boolean containsDuplicateLoops2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if ((i + 1) != nums.length) {
                if (nums[i] == nums[i + 1]) {
                    return true;
                }
            }
        }
        return false;
    }

    // Accepted
    public boolean containsDuplicateHashSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    // TLE
    public boolean containsDuplicateList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(num);
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 4, 5};
        int[] nums2 = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        int[] nums3 = new int[]{1, 2, 3, 4};
        System.out.println(new ContainsDuplicate().containsDuplicateList(nums));
        System.out.println(new ContainsDuplicate().containsDuplicateList(nums2));
        System.out.println(new ContainsDuplicate().containsDuplicateList(nums3));

        System.out.println();
        System.out.println(new ContainsDuplicate().containsDuplicateLoops(nums));
        System.out.println(new ContainsDuplicate().containsDuplicateLoops(nums2));
        System.out.println(new ContainsDuplicate().containsDuplicateLoops(nums3));

        System.out.println();
        System.out.println(new ContainsDuplicate().containsDuplicateLoops2(nums));
        System.out.println(new ContainsDuplicate().containsDuplicateLoops2(nums2));
        System.out.println(new ContainsDuplicate().containsDuplicateLoops2(nums3));

        System.out.println();
        System.out.println(new ContainsDuplicate().containsDuplicateHashSet(nums));
        System.out.println(new ContainsDuplicate().containsDuplicateHashSet(nums2));
        System.out.println(new ContainsDuplicate().containsDuplicateHashSet(nums3));
    }

}
