package com.gopal.regexPattern;

import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class HTMLTagMatcher {
    public static List<String> extractTags(String text) {
        List<String> tags = new ArrayList<>();
        String regex = "<([a-zA-Z][a-zA-Z0-9]*)(\\s[\\w-]+(\\s*=\\s*(?:\".*?\"|'.*?'|[^'\">\\s]+))?)*\\s*/?>|<!--.*?-->|<!\\[CDATA\\[.*?\\]\\]>|<!DOCTYPE.*?>";
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            tags.add(matcher.group());
        }

        return tags;
    }

    public static void main(String[] args) {
        String text = "<div id=\"content\">This is a <b>sample</b> text.</div><!-- Comment -->";
        List<String> extractedTags = extractTags(text);

        for (String tag : extractedTags) {
            System.out.println(tag);
        }
    }
}
