package com.gopal.integerArray;

public class MaxSubArray {
    public static int[] maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        int start = 0; // Starting index of the current subarray
        int maxStart = 0; // Starting index of the subarray with the max sum
        int maxEnd = 0; // Ending index of the subarray with the max sum

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > currentSum + nums[i]) {
                currentSum = nums[i];
                start = i;
            } else {
                currentSum = currentSum + nums[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxStart = start;
                maxEnd = i;
            }
        }

        int[] maxSubArray = new int[maxEnd - maxStart + 1];
        System.arraycopy(nums, maxStart, maxSubArray, 0, maxSubArray.length);
        return maxSubArray;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] maxSubArray = maxSubArray(nums);
        
        System.out.println("Max Subarray:");
        for (int num : maxSubArray) {
            System.out.print(num + " ");
        }
    }
}

