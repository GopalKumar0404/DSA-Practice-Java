package com.gopal.regexPattern;

import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneNumberValidator {
    public static List<String> validatePhoneNumbers(String text) {
        List<String> validPhoneNumbers = new ArrayList<>();
        String regex = "\\+(?:[0-9]?){1,3}(?:[ -]*[0-9]){10,14}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            validPhoneNumbers.add(matcher.group());
        }

        return validPhoneNumbers;
    }

    public static void main(String[] args) {
        String text = "Contact us at +1 555-123-4567 or +44 20 7123 4567 for support.";
        List<String> validatedPhoneNumbers = validatePhoneNumbers(text);

        for (String phoneNumber : validatedPhoneNumbers) {
            System.out.println(phoneNumber);
        }
    }
}

