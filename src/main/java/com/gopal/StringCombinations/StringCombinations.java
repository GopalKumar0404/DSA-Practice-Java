package com.gopal.StringCombinations;

import java.util.ArrayList;
import java.util.List;

public class StringCombinations {
    public static void main(String[] args) {
        String[] strings = {"A", "B", "C","D","E"};
        List<String> combinations = generateCombinations(strings);
        
        System.out.println(combinations.size());
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }

    public static List<String> generateCombinations(String[] strings) {
        List<String> result = new ArrayList<>();
        generateCombinationsHelper(strings, 0, "", result);
        return result;
    }

    private static void generateCombinationsHelper(String[] strings, int currentIndex, String currentCombination, List<String> result) {
        if (currentIndex == strings.length) {
            result.add(currentCombination);
            return;
        }

        // Include the current string in the combination
        generateCombinationsHelper(strings, currentIndex + 1, currentCombination + strings[currentIndex], result);

        // Exclude the current string in the combination
        generateCombinationsHelper(strings, currentIndex + 1, currentCombination, result);
    }
}
