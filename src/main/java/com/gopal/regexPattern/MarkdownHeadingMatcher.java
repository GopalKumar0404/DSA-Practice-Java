package com.gopal.regexPattern;

import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class MarkdownHeadingMatcher {
    public static List<String> matchHeadings(String text) {
        List<String> headings = new ArrayList<>();
        String regex = "^(#{1,6})\\s(.+)$";
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String level = matcher.group(1);
            String headingText = matcher.group(2);
            headings.add("Level " + level.length() + ": " + headingText);
        }

        return headings;
    }

    public static void main(String[] args) {
        String text = "# Heading 1\n## Heading 2\n### Heading 3\nThis is a paragraph.";
        List<String> matchedHeadings = matchHeadings(text);

        for (String heading : matchedHeadings) {
            System.out.println(heading);
        }
    }
}

