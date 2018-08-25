package com.company;

import java.util.ArrayList;
import java.util.List;

public class Lcs {
    static String lcs(String a, String b) {
        char[] aChar = a.toCharArray();
        List<Character> aList = new ArrayList<>();
        for (char c : aChar){
            aList.add(c);
        }
        char[] bChar = b.toCharArray();
        List<Character> bList = new ArrayList<>();
        for (char c : bChar){
            bList.add(c);
        }

        aList.stream().filter(x -> x == bList.get(x.)

        return "";
    }
}
