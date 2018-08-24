package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Lcs {

    static List<String> results = new ArrayList<>();

    static String lcs(String a, String b) {
        List<Character> bList = new ArrayList<>();
        for (Character c : b.toCharArray()) {
            bList.add(c);
        }
        for (int i = 0; i< a.length(); i++) {
            if (bList.contains(a.charAt(i))) {
                String bSub = b.substring(b.indexOf(a.charAt(i)));
                bList = b.
            }
        }
        return "";
    }
}