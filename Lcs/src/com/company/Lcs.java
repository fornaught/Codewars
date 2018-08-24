package com.company;

class Lcs {

    static String lcs(String a, String b) {
        recLcs(a,b, "");
        return "";
    }

    static String recLcs(String a, String b, String result){
        if (a == "" || b == "") {
            return result;
        }
        for (int i = 0; i < a.length(); i++){
            for (int j = 0; j < b.length(); j++){
                if (a.charAt(i) == b.charAt(j)){
                    result += a.charAt(i);
                    System.out.println(result);
                    recLcs(a.substring(i + 1), b.substring(j + 1), result);
                    break;
                }
            }
            if (i == a.length() -1){
                System.out.println("hoi " + result);
                return result;
            }
        }
        return "shieet";
    }
}