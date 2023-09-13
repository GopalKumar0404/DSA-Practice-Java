package com.gopal.regexPattern;

import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class URLWithQueryParameterMatcher {
    public static List<String> matchURLsWithQueryParams(String text) {
        List<String> urls = new ArrayList<>();
        String regex = "https?://[a-zA-Z0-9.-]+(/[a-zA-Z0-9.-]*)?(\\?([a-zA-Z0-9_]+=[a-zA-Z0-9_]+(&|$))*)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            urls.add(matcher.group());
        }

        return urls;
    }

    public static void main(String[] args) {
        String text = "Visit our website at https://www.example.com/path?param1=value1&param2=value2 or check http://example.org for more info.";
        List<String> matchedURLs = matchURLsWithQueryParams(text);

        for (String url : matchedURLs) {
            System.out.println(url);
        }
    }
}
