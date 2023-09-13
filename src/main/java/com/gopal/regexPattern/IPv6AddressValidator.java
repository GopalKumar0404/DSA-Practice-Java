package com.gopal.regexPattern;

import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class IPv6AddressValidator {
    public static List<String> validateIPv6Addresses(String text) {
        List<String> validIPv6Addresses = new ArrayList<>();
        String regex = "^([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$|^(([0-9a-fA-F]{1,4}:){6}|::([0-9a-fA-F]{1,4}:){5}|([0-9a-fA-F]{1,4})?::([0-9a-fA-F]{1,4}:){4}|((([0-9a-fA-F]{1,4}:)?[0-9a-fA-F]{1,4})?::([0-9a-fA-F]{1,4}:){3}|((([0-9a-fA-F]{1,4}:){0,2}[0-9a-fA-F]{1,4})?::([0-9a-fA-F]{1,4}:){2}|((([0-9a-fA-F]{1,4}:){0,3}[0-9a-fA-F]{1,4})?::[0-9a-fA-F]{1,4}:|((([0-9a-fA-F]{1,4}:){0,4}[0-9a-fA-F]{1,4})?::)|::)))(%.+)?\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            validIPv6Addresses.add(matcher.group());
        }

        return validIPv6Addresses;
    }

    public static void main(String[] args) {
        String text = "Valid IPv6 addresses: 2001:0db8:85a3:0000:0000:8a2e:0370:7334, ::1. Invalid addresses: 192.168.0.1, 2001:0db8:85a3:0000:0000:8a2e:0370::7334.";
        List<String> validatedIPv6Addresses = validateIPv6Addresses(text);

        for (String ipv6Address : validatedIPv6Addresses) {
            System.out.println(ipv6Address);
        }
    }
}

