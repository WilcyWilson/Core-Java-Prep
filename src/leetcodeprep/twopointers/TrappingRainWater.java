package leetcodeprep.twopointers;//LEFT APPROACH

import java.util.Arrays;

public class TrappingRainWater {

    public static void main(String[] args) {
//        System.out.println(trappingRainWaterOptimalWithDescription(new int[]{5, 4, 2, 5, 7, 8, 6, 2, 9, 1, 6, 9, 1, 0, 3, 7, 7, 7, 3, 4, 7})); // 47

        System.out.println(trappingRainWaterOptimalWithDescription(new int[]{0, 0, 0})); // 0

        System.out.println(trappingRainWaterOptimalWithDescription(new int[]{6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3}));//83

        System.out.println(trappingRainWaterOptimalWithDescription(new int[]{0, 7, 1, 4, 6})); //7

        System.out.println(trappingRainWaterOptimalWithDescription(new int[]{0, 1, 0, 2, 1, 5, 1, 3, 2, 1, 2, 1})); // 5

        System.out.println(trappingRainWaterOptimalWithDescription(new int[]{0, 7, 1, 4, 6})); //7

        System.out.println(trappingRainWaterOptimalWithDescription(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 6

        System.out.println(trappingRainWaterOptimalWithDescription(new int[]{5, 5, 1, 7, 1, 1, 5, 2, 7, 6})); //23

        System.out.println(trappingRainWaterOptimalWithDescription(new int[]{4, 4, 4, 7, 1, 0})); //0

        System.out.println(trappingRainWaterOptimalWithDescription(new int[]{1})); // 0

        System.out.println(trappingRainWaterOptimalWithDescription(new int[]{1, 7, 5})); //0

        System.out.println(trappingRainWaterOptimalWithDescription(new int[]{4, 2, 3})); // 1

        System.out.println(trappingRainWaterOptimalWithDescription(new int[]{0, 1, 0, 2, 1, 5, 1, 3, 2, 1, 2, 1})); // 5

        System.out.println(trappingRainWaterOptimalWithDescription(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 6

        System.out.println(trappingRainWaterOptimalWithDescription(new int[]{4, 2, 0, 3, 2, 5})); // 9

        System.out.println(trappingRainWaterOptimal(new int[]{5, 4, 2, 5, 7, 8, 6, 2, 9, 1, 6, 9, 1, 0, 3, 7, 7, 7, 3, 4, 7})); // 47

        System.out.println(trappingRainWaterOptimal(new int[]{0, 0, 0})); // 0

        System.out.println(trappingRainWaterOptimal(new int[]{6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3}));//83

        System.out.println(trappingRainWaterOptimal(new int[]{0, 7, 1, 4, 6})); //7

        System.out.println(trappingRainWaterOptimal(new int[]{0, 1, 0, 2, 1, 5, 1, 3, 2, 1, 2, 1})); // 5

        System.out.println(trappingRainWaterOptimal(new int[]{0, 7, 1, 4, 6})); //7

        System.out.println(trappingRainWaterOptimal(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 6

        System.out.println(trappingRainWaterOptimal(new int[]{5, 5, 1, 7, 1, 1, 5, 2, 7, 6})); //23

        System.out.println(trappingRainWaterOptimal(new int[]{4, 4, 4, 7, 1, 0})); //0

        System.out.println(trappingRainWaterOptimal(new int[]{1})); // 0

        System.out.println(trappingRainWaterOptimal(new int[]{1, 7, 5})); //0

        System.out.println(trappingRainWaterOptimal(new int[]{4, 2, 3})); // 1

        System.out.println(trappingRainWaterOptimal(new int[]{0, 1, 0, 2, 1, 5, 1, 3, 2, 1, 2, 1})); // 5

        System.out.println(trappingRainWaterOptimal(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 6

        System.out.println(trappingRainWaterOptimal(new int[]{4, 2, 0, 3, 2, 5})); // 9

        System.out.println();

        System.out.println(trappingRainWaterWorst(new int[]{5, 4, 2, 5, 7, 8, 6, 2, 9, 1, 6, 9, 1, 0, 3, 7, 7, 7, 3, 4, 7})); // 47

        System.out.println(trappingRainWaterWorst(new int[]{0, 0, 0})); // 0

        System.out.println(trappingRainWaterWorst(new int[]{6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3}));//83

        System.out.println(trappingRainWaterWorst(new int[]{0, 7, 1, 4, 6})); //7

        System.out.println(trappingRainWaterWorst(new int[]{0, 1, 0, 2, 1, 5, 1, 3, 2, 1, 2, 1})); // 5

        System.out.println(trappingRainWaterWorst(new int[]{0, 7, 1, 4, 6})); //7

        System.out.println(trappingRainWaterWorst(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 6

        System.out.println(trappingRainWaterWorst(new int[]{5, 5, 1, 7, 1, 1, 5, 2, 7, 6})); //23

        System.out.println(trappingRainWaterWorst(new int[]{4, 4, 4, 7, 1, 0})); //0

        System.out.println(trappingRainWaterWorst(new int[]{1})); // 0

        System.out.println(trappingRainWaterWorst(new int[]{1, 7, 5})); //0

        System.out.println(trappingRainWaterWorst(new int[]{4, 2, 3})); // 1

        System.out.println(trappingRainWaterWorst(new int[]{0, 1, 0, 2, 1, 5, 1, 3, 2, 1, 2, 1})); // 5

        System.out.println(trappingRainWaterWorst(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 6

        System.out.println(trappingRainWaterWorst(new int[]{4, 2, 0, 3, 2, 5})); // 9

    }

    public static int trappingRainWaterOptimal(int[] height) {
        int left = 0, right = height.length - 1, leftMax = -1, rightMax = -1, water = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left++];
                } else {
                    water += leftMax - height[left++];
                }
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right--];
                } else {
                    water += rightMax - height[right--];
                }
            }
        }
        return water;
    }

    public static int trappingRainWaterOptimalWithDescription(int[] height) {
        int left = 0, right = height.length - 1, leftMax = -1, rightMax = -1, water = 0;
        System.out.println(Arrays.toString(height));
        while (left < right) {
            System.out.printf("""
                    while (left < right)
                    %d < %d
                    %n""", left, right);
            System.out.printf("""
                    if (height[left] < height[right])
                    %d < %d
                    %n""", height[left], height[right]);
            if (height[left] < height[right]) {
                System.out.printf("""
                        if (height[left] >= leftMax)
                        %d >= %d
                        %n""", height[left], leftMax);
                if (height[left] >= leftMax) {
                    leftMax = height[left++];
                    System.out.printf("""
                            leftMax = height[left++];
                            leftMax = %d
                            %n""", leftMax);
                } else {
                    System.out.printf("""
                            water += leftMax - height[left++];
                            water = %d + %d - %d
                            %n""", water, leftMax, height[left]);
                    water += leftMax - height[left++];
                }
            } else {
                System.out.printf("""
                        height[right] >= rightMax
                        %d >= %d
                        %n""", height[right], rightMax);
                if (height[right] >= rightMax) {
                    rightMax = height[right--];
                    System.out.printf("""
                            rightMax = height[right--];
                            rightMax = %d
                            %n""", rightMax);
                } else {
                    System.out.printf("""
                            water += rightMax - height[right--];
                            water = %d + %d - %d
                            %n""", water, rightMax, height[right]);
                    water += rightMax - height[right--];
                }
            }
        }
        return water;
    }

    public static int trappingRainWaterWorst(int[] height) {
        int left = 0, right = 1, traparea = 0;
        boolean found;

        if (height.length <= 2) {
            return 0;
        }

        while (height[left] <= height[right] && right < height.length - 1) {
            left++;
            right++;
        }

        //NextTrapArea:
        while (left < right && right < height.length) {
            found = false;
            //Checking for dips after the starting block.
            if (height[left] > height[right]) {
                //Boolean value in case the pair value greater or equal to left index is not found.
                //found=false;
                //Dip located, find if rise equal to or greater than left index exists or not.
                for (int i = left; i < height.length; i++) {
                    //right++;
                    //Checking for rising of a block after dip.
                    if (right < height.length - 1 && height[left] <= height[right + 1]) {
                        found = true;
                        right++;

                        //Following loop traverses the indexes between the left and right block and
                        //calculates traparea using the left as the capping wall.
                        for (int j = left + 1; j < right; j++) {
                            traparea += height[left] - height[j];
                        }
                        left = right;
                        right = left + 1;
                        break;
                        //continue NextTrapArea;  //or use break statement.
                    } else {
                        right++;
                    }
                }

            }
            if ((right < height.length) && height[left] <= height[right]) {
                left++;
                right++;
            }
            // if the following block is equal or taller, starting point shifts to that block(i.e. no dip).
            else if (!found) {
                int currentMax = 0;
                int mostSuitablePointer = 0;
                for (int j = left + 1; j < height.length; j++) {
                    if (height[j] >= currentMax) {
                        currentMax = height[j];
                        mostSuitablePointer = j;
                    }
                }
                //largest on the right side found, capping wall is right and traparea calculated.
                for (int j = mostSuitablePointer - 1; j >= left + 1; j--) {

                    traparea += height[mostSuitablePointer] - height[j];
                }
                left = mostSuitablePointer;
                right = mostSuitablePointer + 1;
            }
        }

        return traparea;
    }
}
