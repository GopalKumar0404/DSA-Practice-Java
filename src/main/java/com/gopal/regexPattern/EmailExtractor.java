package com.gopal.regexPattern;

import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class EmailExtractor {
    public static List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();
        String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            emails.add(matcher.group());
        }

        return emails;
    }

    public static void main(String[] args) {
        String text = "This is a sample text with emails: john.doe@example.com and jane.smith@test.org. Please contact us at contact@company.co.";
        List<String> extractedEmails = extractEmails(text);

        for (String email : extractedEmails) {
            System.out.println(email);
        }
    }
}
