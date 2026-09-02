package leetcodeprep.slidingwindow;

public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int pointer = 0;
        double average;
        double maxAverage = -Double.MAX_VALUE;
        int pointerEnd = k;

        while (pointer < (nums.length - k + 1)) {
            int sum = 0;
            for (int i = pointer; i < pointerEnd; i++) {
                sum += nums[i];
            }
            average = (double) sum / k;
            if (average > maxAverage) {
                maxAverage = average;
            }
            pointer++;
            pointerEnd++;
        }
        return maxAverage;
    }

    public double findMaxAverageOptimal(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum / k;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumAverageSubarrayI().findMaxAverageOptimal(new int[]{-1}, 1));
        System.out.println(new MaximumAverageSubarrayI().findMaxAverageOptimal(new int[]{1, 12, -5, -6, 50, 3}, 4));

        System.out.println(new MaximumAverageSubarrayI().findMaxAverage(new int[]{-1}, 1));
        System.out.println(new MaximumAverageSubarrayI().findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }
}
