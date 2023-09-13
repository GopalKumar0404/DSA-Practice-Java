package com.gopal.integerArray;

import java.util.*;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
            	
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
//            System.out.println(map);
        }
        throw new IllegalArgumentException("No solution");
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 2,11, 15,2};
        int target1 = 18;
        
//        System.out.println(Arrays.toString(twoSum(nums1, target1))); 
        
        int[] nums2 = {5, 2, 4};
        int target2 = 6;
        System.out.println(Arrays.toString(twoSum(nums2, target2))); // Output: [1, 2]
    }
}
