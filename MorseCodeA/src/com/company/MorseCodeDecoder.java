package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MorseCodeDecoder {
    public static String decodeBits(String bits) {
        System.out.println(bits);
        int count = 10;
        String pattern = "(1{1,})|(?:0{1,})";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(bits);
        while (m.find()) {
            if (m.end() - m.start() < count) {
                count = m.end() - m.start();
                System.out.println("hoi" + (m.end() - m.start()));
            }
        }
        System.out.println("hoi2 " + count);
        char[] bitsArr = bits.toCharArray();
        int start = bits.indexOf('1', 0);
        StringBuilder result = new StringBuilder();
        for (int i = start; i < bitsArr.length; i += count) {
            result.append(bitsArr[i]);
        }
        System.out.println(result.toString());
        String pattern2 = "(0{7})|(1{1,3})|(0{1,3})";
        Pattern p2 = Pattern.compile(pattern2);
        Matcher m2 = p2.matcher(result.toString());
        StringBuilder result2 = new StringBuilder();

//        try(Scanner s = new Scanner(result2.toString())) {
//            s.findAll(pattern2)
//                    .collect(Collectors.groupingBy(MatchResult::group, TreeMap::new,Collectors.counting()))
//                    .forEach((k, v) -> System.out.printf("%s\t%s\n",k,v));
//        }

        List<String> matches = new ArrayList<>();
        String a = "";
        while (m2.find()) {
            System.out.println(m2.group(0));
//            matches.add(m2.group(0));
            switch (m2.group(0)) {
                case "1":
                    result2.append(".");
                    a += ".";
                    break;
                case "111":
                    result2.append("-");
                    a += "-";
                    break;
                case "000":
                    result2.append(' ');
                    a += " ";
                    break;
                case "0000000":
                    result2.append("   ");
                    a += "   ";
                    break;
                case "0":
                    break;
            }
        }
        System.out.println(result2.toString());
        return a;
    }

    public static String decompose(String s) {
        return java.text.Normalizer.normalize(s, java.text.Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    public static String decodeMorse(String morseCode) {
        System.out.println(MorseCode.get(morseCode));
        String[] words = morseCode.split("   ");
        List<String> chars = Arrays.stream(words).filter(x -> x != " ").collect(Collectors.toList());
        String result = "";
        for (String s : chars) {
            String[] letters = s.split(" ");
            for (int i = 0; i < letters.length; i++) {
                result += MorseCode.get(letters[i]);
                }
            result += " ";
        }
        System.out.println(result);
        return result.trim();
    }
}
