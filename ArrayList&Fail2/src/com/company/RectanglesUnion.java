package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class RectanglesUnion {
    static HashMap<int[], Integer> lowPoints = new HashMap<>();
    static HashMap<int[], Integer> highPoints = new HashMap<>();
    static ArrayList<int[]> rStartingPoints = new ArrayList<>();
    static int sum = 0;

    public static int calculateSpace(int[][] rectangles) {
        lowPoints.clear();
        highPoints.clear();
        sum = 0;

        for (int[] r : rectangles) {
            checkOverlap(r);
        }
//         for (int[] key : lowPoints.keySet()) {
//             for (int i : key){
//                 System.out.print(i);
//             }
//             System.out.println();
//         }
        return sum;
    }

    public static void checkOverlap(int[] r) {

    }
}
