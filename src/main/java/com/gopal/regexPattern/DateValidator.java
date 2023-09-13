package com.gopal.regexPattern;

import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class DateValidator {
    public static List<String> validateDates(String text) {
        List<String> validDates = new ArrayList<>();
        String regex = "\\b(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/(19|20)\\d{2}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            validDates.add(matcher.group());
        }

        return validDates;
    }

    public static void main(String[] args) {
    	// Valid date format is MM/DD/YYYY
        String text = "Valid dates: 12/31/2023, 01/15/2029. Invalid dates: 22-12-2021, 2023/12/31.";
        List<String> validDates = validateDates(text);

        for (String date : validDates) {
            System.out.println(date);
        }
    }
}
