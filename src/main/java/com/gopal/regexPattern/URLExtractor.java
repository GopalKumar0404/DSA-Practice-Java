package com.gopal.regexPattern;

import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class URLExtractor {
    public static List<String> extractURLs(String text) {
        List<String> urls = new ArrayList<>();
        String regex = "\\bhttps?://[\\w/:%#\\$&\\?\\(\\)~\\.=\\+\\-]+\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            urls.add(matcher.group());
        }

        return urls;
    }

    public static void main(String[] args) {
        String text = "Visit our website at https://www.example.com or check http://example.org for more info.";
        List<String> extractedURLs = extractURLs(text);

        for (String url : extractedURLs) {
            System.out.println(url);
        }
    }
}

