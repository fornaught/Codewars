package com.company;


import java.util.LinkedList;
import java.util.List;

public class ProperFractions {
    public static long properFractions(long n) {
        for (int i = 3; i < n; i+=2) {

        }
        return 0;
    }
}




//    List<Long> fractions = new LinkedList<>();
//        System.out.println("input " + n);
//                long temp = 1;
//                long result = n;
//                for (long i = n /2; i > 2; i /= 2) {
//                System.out.println(i);
//                if (i % 1 == 0) {
//                for (int j = 1; temp < n/2; j ++){
//        temp = j;
//        for (;temp < n/2; temp++)
//        if (!fractions.contains(temp))
//        {
//        fractions.add(temp);
//        }
//        temp+= temp;
//        System.out.println(temp);
//        }
//        }
//        }
//        System.out.println(fractions.size());
//        return result - fractions.size();