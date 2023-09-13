package com.gopal.integerArray;

public class ArrayRotation {
    public static void rotateArray(int[] nums, int k) {
        // Your code here
        
        // Hint: Think about reversing subarrays to achieve the rotation
    	
    	int n = nums.length;
        k %= n; // To handle cases where k is larger than array length
        System.out.println("n : "+ n+" , k : "+ k);
        reverse(nums, 0, n - 1); // Reverse the entire array
        reverse(nums, 0, k - 1); // Reverse the first k elements
        reverse(nums, k, n - 1); // Reverse the remaining elements
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        for(int t: nums) {
        	System.out.print(t+" ");
        }
        System.out.println();
    }
        
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 266;
        rotateArray(arr, k);
        
        System.out.println("Rotated array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
