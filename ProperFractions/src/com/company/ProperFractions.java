package com.company;

import java.util.LinkedList;
import java.util.List;

public class ProperFractions {
    public static long properFractions(long n) {
        System.out.println("input " + n);
        long counter = 0;
        List<Long> count2 = new LinkedList<>();
        for (long i = 1; i <= 10 || i < n/2; i++) {
            if ((i % n == 0)) {
                counter++;
                if (!count2.contains(i));
                {
                    count2.add(i);
                }
            }
        }
        return count2.size();
    }
}