package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RectanglesUnion {
    static HashMap<int[], Integer> startingPoints = new HashMap<>();

    static int sum = 0;

    public static int calculateSpace(int[][] rectangles) {
        startingPoints.clear();
        sum = 0;

        for (int[] r : rectangles) {
            checkOverlap(r);
        }


        for (Map.Entry<int[], Integer> entry : startingPoints.entrySet()) {
            int[] key = entry.getKey();
            System.out.println("key: " + key[0] + key[1]);
            System.out.println("value:" + entry.getValue());
        }
         System.out.println(startingPoints.keySet().size());
        return sum;
    }

    public static void checkOverlap(int[] r) {
//        List<int[]> a = startingPoints.entrySet().stream().filter(x -> x.getKey()[0] < r[0] && x.getKey()[1] >= r[1] && x.getKey()[1] <= r[3] && x.getValue() +x.getKey()[0] > r[0]).map(x -> x.getKey()).collect(Collectors.toList());

        List<int[]> b = startingPoints.entrySet().stream().filter(x -> x.getKey()[0] < r[0] && x.getKey()[1] >= r[1] && x.getKey()[1] <= r[3] && x.getValue() +x.getKey()[0] > r[0]).map(x -> x.getKey()).collect(Collectors.toList());
        for (int i = b.size()-2; i< b.size(); i++)
        {
            System.out.println(b.size());
//            System.out.println("keyget"+ startingPoints.get(b.get(i)));
            startingPoints.put(new int[] {b.get(i)[0], r[1]}, r[2] - b.get(i)[0]);
        }
        if (b.isEmpty()) { // isEmpty needs to change to is outside of any entries.
            System.out.println("adding two");
            startingPoints.put(new int[] {r[0], r[1]}, r[2] -r[0]);
            startingPoints.put(new int[] {r[0], r[3]}, r[2] -r[0]);
        }
    }
}
