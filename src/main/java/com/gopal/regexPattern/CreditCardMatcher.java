package com.gopal.regexPattern;

import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class CreditCardMatcher {
    public static List<String> matchCreditCards(String text) {
        List<String> creditCards = new ArrayList<>();
        String regex = "\\b(?:\\d[ -]*?){13,19}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            creditCards.add(matcher.group());
        }

        return creditCards;
    }

    public static void main(String[] args) {
        String text = "Card numbers: 4111-1111-1111-1111, 1234 5678 9012 3456, 6011-0009-9013-9424.";
        List<String> matchedCreditCards = matchCreditCards(text);

        for (String card : matchedCreditCards) {
            System.out.println(card);
        }
    }
}
