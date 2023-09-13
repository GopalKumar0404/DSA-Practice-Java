package com.gopal.integerArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort the intervals by their start values
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (interval[0] <= currentInterval[1]) {
                // Overlapping intervals, merge them
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {
                // Non-overlapping interval, add the current interval and start a new one
                mergedIntervals.add(currentInterval);
                currentInterval = interval;
            }
        }

        // Add the last interval
        mergedIntervals.add(currentInterval);

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{2, 6},{8, 10}, {1, 3},  {15, 18}};
//    	int[][] intervals = {{8, 13}, {10, 14}, {6, 10}, {15, 18}};
        int[][] mergedIntervals = merge(intervals);
        
        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
        
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
