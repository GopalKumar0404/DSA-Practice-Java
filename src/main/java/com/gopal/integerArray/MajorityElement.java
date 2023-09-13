package com.gopal.integerArray;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3,4,3,8,3,4,6,3,1};
        MajorityElement solution = new MajorityElement();
        System.out.println(solution.majorityElement(nums)); // Output: 3
    }
}




