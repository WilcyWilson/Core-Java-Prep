package leetcodeprep.twopointers;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxArea = 0;

        while (left < right) {
            int area = (right - left) * Math.min(height[right], height[left]);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{3})); // 0
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 1})); // 1
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{8, 7, 2, 1})); // 7
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 2, 1})); // 2
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 2, 4, 3})); // 4
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49

    }
}
