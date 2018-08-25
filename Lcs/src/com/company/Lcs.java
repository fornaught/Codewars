package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Lcs {

    static List<String> results = new ArrayList<>();
    static List<Integer> branchStarts = new ArrayList<>();

    static String lcs(String a, String b) {
        System.out.println(a);
        System.out.println(b);
        int tempStart = 0;
        for (int j = 0; j < a.length(); j++){
            branchStarts.clear();
            String result = "";
            String tempB = b;
            List<Character> bList = new ArrayList<>();
            for (Character c : b.toCharArray()) {
                bList.add(c);
            }
            for (int i = tempStart; i < a.length(); i++) {
                System.out.println("bls" + bList.size());
                System.out.println(branchStarts.size());
                if (bList.contains(a.charAt(i)) && !branchStarts.contains(i)) {
                    System.out.println(a.charAt(i));
                    result += a.charAt(i);
                    System.out.println(b.indexOf(a.charAt(i)));
                    bList.subList(0, bList.indexOf(a.charAt(i))).clear();
                    System.out.println(bList.toString());
                    System.out.println(tempB);
                    tempB = tempB.substring(tempB.indexOf(a.charAt(i)));
                    System.out.println(tempB);
                    branchStarts.add(i);
                }
            }
            tempStart++;
            results.add(result);
        }
        System.out.println("results:");
        String max = "";
        for (String s : results) {
            if (s.length() > max.length()){
                max = s;
            }
            System.out.println(s);
        }
        return max;
    }
}